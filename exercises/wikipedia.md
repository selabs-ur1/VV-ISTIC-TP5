# Random Wikipedia walker

Using Selenium, create a small program that, starting from the main page https://www.wikipedia.org/, walks trough a sequence of random links and takes a snapshot of the last page.
The process is as follows:

 1. Navigate to the main page https://www.wikipedia.org/
 2. Select a random link in the page
 3. Navigate to the link
 4. Repeat steps 2 to 3 until you have visited 10 different pages
 5. Take a snapshot of the current page and save it

Include the code of the walker and the snapshot in this document.

## Answer

Authors: Dufeil Jaufret & Gentile Brian

```python
from selenium import webdriver
from selenium.webdriver.common.by import By
import time
import random

driver = webdriver.Chrome()
driver.get("https://www.wikipedia.org/")

def take_screenshot(file_name):
    driver.save_screenshot(file_name + ".png")



visited_links = []

for _ in range(10):

    time.sleep(3)

    driver.get("https://www.wikipedia.org/")

    links = driver.find_elements(By.CSS_SELECTOR, "a[href]")

    time.sleep(3)

    remaining_links = list(set(links) - set(visited_links))
    
    if not remaining_links:
        print("no more links")
        break

    hazard = random.choice(remaining_links)
    hazard_url = hazard.get_attribute("href")
    
    driver.get(hazard_url)
    
    visited_links.append(hazard)

    print("Visited page: " + hazard_url)

take_screenshot("picture")
driver.quit()
```

![image info](./wikipediaPicture.png)