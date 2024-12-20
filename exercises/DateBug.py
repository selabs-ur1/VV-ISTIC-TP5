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
