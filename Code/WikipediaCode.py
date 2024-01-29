import time
import random
from selenium import webdriver
from selenium.webdriver.common.by import By



def take_screenshot(driver):
    driver.save_screenshot("screenshot.png")

def main():
    
    chrome_options = webdriver.ChromeOptions()
    chrome_options.add_argument("--headless")  
    driver = webdriver.Chrome(options=chrome_options)
    num_pages_to_visit = 10
    try:
        driver.get("https://www.wikipedia.org/")
        
        for _ in range(num_pages_to_visit):
            links = driver.find_elements(By.CSS_SELECTOR, "a[href]")
            time.sleep(1)
        
            random_link = random.choice(links)
            random_url = random_link.get_attribute("href")
            driver.get(random_url)

        take_screenshot(driver)
        print("Task Done")

    except Exception as e:
        print(f"An error occurred: {e}")

    finally:
        
        driver.quit()

if __name__ == "__main__":
    main()
