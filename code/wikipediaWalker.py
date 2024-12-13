from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service
from selenium.webdriver.firefox.options import Options
import random
import time

# Set up Selenium WebDriver options
options = Options()
options.add_argument('--headless')  # Run in headless mode
options.add_argument('--disable-gpu')
options.add_argument('--window-size=1920x1080')

# Initialize WebDriver (assuming GeckoDriver is in your PATH)
service = Service('/usr/local/bin/geckodriver')  # Replace with the path to geckodriver if necessary
driver = webdriver.Firefox(service=service, options=options)

try:
    print("coucou1")
    # Step 1: Navigate to the main Wikipedia page
    driver.get("https://www.wikipedia.org/")

    # Step 2-4: Walk through 10 random links
    visited_urls = set()
    for _ in range(10):
        print("coucou2")
        # Find all links on the page
        links = driver.find_elements(By.TAG_NAME, "a")

        # Filter out links without href attributes
        valid_links = [link.get_attribute("href") for link in links if link.get_attribute("href")]

        # Choose a random link that hasn't been visited yet
        random.shuffle(valid_links)
        next_url = None
        for link in valid_links:
            if link.startswith("https://") and link not in visited_urls:
                next_url = link
                break

        if not next_url:
            print("No more unvisited links available. Stopping early.")
            break

        # Visit the link
        visited_urls.add(next_url)
        driver.get(next_url)
        time.sleep(2)  # Wait for the page to load

    # Step 5: Take a snapshot of the current page
    snapshot_path = "wikipedia_snapshot.png"
    driver.save_screenshot(snapshot_path)
    print(f"Snapshot saved as {snapshot_path}")

except Exception as e:
    print(f"An error occurred: {e}")

finally:
    # Close the WebDriver
    driver.quit()
