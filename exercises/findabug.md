## Find a bug

Clone the [Simba Organizer repository](https://github.com/barais/doodlestudent/) and follow the instructions to run the application on your machine.

Find a bug in the application. 

With the help of Selenium and the Page Object Model desing pattern write a simple test that fails for this bug.

Optionally make a pull request to the project.

Include in this document the code of the test and, if you did it, the link to the pull request.

## Answer

This script creates a new poll and goes to the second step of the creation process to set the date. 
After that, it goes to the third step to submit the poll creation and then goes back to the second step.
This creates a second date element in the page, which is a bug.

```python
from selenium import webdriver
import time

from exercises.NewPollPageObject import NewPollPageObject

driver = webdriver.Chrome()
driver.get("http://localhost:4200/create")
driver.implicitly_wait(10)

new_poll_page = NewPollPageObject(driver)
new_poll_page.set_title("Poll title")
new_poll_page.set_location("Poll location")
new_poll_page.set_description("Poll description")
new_poll_page.click_next()
new_poll_page.set_date()
new_poll_page.click_next()
time.sleep(2)
new_poll_page.click_previous()
time.sleep(10)
```
