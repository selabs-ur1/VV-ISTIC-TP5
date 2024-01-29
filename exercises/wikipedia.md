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

### Code 
```python
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time
import random

driver = webdriver.Chrome()  # Make sure you have ChromeDriver installed and in your PATH

driver.get("https://www.wikipedia.org/")

for i in range(10):
    # Find all links on the page
    links = driver.find_elements(By.TAG_NAME, "a")

    # Filter out links that do not have an href attribute
    valid_links = [link for link in links if link.get_attribute("href")]

    if not valid_links:
        break

    random_link = random.choice(valid_links)

    link_url = random_link.get_attribute("href")

    driver.get(link_url)

    time.sleep(2)

driver.save_screenshot("snapshot.png")

driver.quit()
```

### Snapshot Result

![image](https://github.com/Gham0n/VV-ISTIC-TP5/assets/124994183/394c7031-57da-44e1-b86d-79e4756e749e)
