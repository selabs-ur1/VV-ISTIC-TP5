from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.common.exceptions import NoSuchElementException
import random
import time

# Configure Selenium WebDriver
options = Options()
options.add_argument('--headless')  # Run in headless mode for performance
options.add_argument('--no-sandbox')
service = Service('/opt/homebrew/bin/chromedriver')  # Replace with the correct path to chromedriver

# Initialize WebDriver
driver = webdriver.Chrome(service=service, options=options)

try:
    # Step 1: Navigate to the main page
    driver.get('https://www.wikipedia.org/')

    visited_pages = 0

    while visited_pages < 10:
        time.sleep(2)  # Allow the page to load

        # Find all links on the page
        links = driver.find_elements(By.TAG_NAME, 'a')
        valid_links = [link for link in links if link.get_attribute('href')]

        if not valid_links:
            print("No valid links found on this page.")
            break

        # Step 2: Select a random link
        random_link = random.choice(valid_links).get_attribute('href')

        # Step 3: Navigate to the selected link
        driver.get(random_link)

        visited_pages += 1

    # Step 4: Take a snapshot of the current page
    snapshot_path = 'wikipedia_snapshot.png'
    driver.save_screenshot(snapshot_path)
    print(f"Snapshot saved at {snapshot_path}")

finally:
    # Close the WebDriver
    driver.quit()