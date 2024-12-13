from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.common.exceptions import (
    WebDriverException, 
    StaleElementReferenceException
)
import random
import time

# Sélection dynamique du WebDriver
try:
    # Essayer différents drivers dans un ordre spécifique
    drivers = [
        webdriver.Firefox,  # Firefox par défaut
        webdriver.Safari,   # Safari pour macOS
        webdriver.Edge,     # Edge pour Windows
        webdriver.Chrome    # Chrome comme dernier recours
    ]
            
    driver = None
    for driver_class in drivers:
        try:
            driver = driver_class()
            break
        except WebDriverException:
            continue
    if not driver:
        raise WebDriverException("Aucun driver de navigateur disponible")
            
except Exception as e:
    print(f"Erreur d'initialisation du driver : {e}")
    raise

wait = WebDriverWait(driver, 10)

try:
    # Step 1: Navigate to the main page
    driver.get("https://www.wikipedia.org/")
    visited_urls = set()
    max_pages = 10

    for _ in range(max_pages):
        # Step 2: Find all links on the page
        try:
            links = driver.find_elements(By.XPATH, "//a[@href]")
            
            # Nouvelle vérification pour gérer les éléments obsolètes
            valid_links = []
            for link in links:
                try:
                    # Vérification supplémentaire pour éviter les éléments obsolètes
                    if link.is_displayed() and 'href' in link.get_attribute('outerHTML'):
                        valid_links.append(link)
                except StaleElementReferenceException:
                    # Ignorer les éléments devenus obsolètes
                    continue
            
            if not valid_links:
                print("No valid links found. Exiting.")
                break

            # Step 3: Select a random link and click it
            next_link = random.choice(valid_links)
            url = next_link.get_attribute("href")

            # Avoid revisiting the same page
            if url in visited_urls:
                continue
            visited_urls.add(url)

            # Navigate to the link
            try:
                # Essayer de cliquer normalement
                next_link.click()
            except StaleElementReferenceException:
                # Si l'élément est devenu obsolète, réessayer de trouver et cliquer
                try:
                    # Retrouver le lien et cliquer
                    driver.find_element(By.XPATH, f"//a[@href='{url}']").click()
                except Exception:
                    # Utiliser JavaScript comme dernière option
                    driver.execute_script(f"window.location.href = '{url}'")
            
            time.sleep(2)  # Allow some time for the page to load

        except StaleElementReferenceException:
            # Gérer l'exception globalement si nécessaire
            print("Stale element encountered. Retrying...")
            continue

    # Step 4: Take a snapshot of the last page
    screenshot_path = "final_page_screenshot.png"
    driver.save_screenshot(screenshot_path)
    print(f"Snapshot saved to {screenshot_path}")

finally:
    # Close the browser
    driver.quit()