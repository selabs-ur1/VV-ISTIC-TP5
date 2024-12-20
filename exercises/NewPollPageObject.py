from selenium.webdriver.common.by import By


class NewPollPageObject:

    PAGE_NUMBER = 1

    PAGE_1_NEXT = (By.XPATH, "//p-button[@label='Next']/button")

    PAGE_2_PREVIOUS = (By.XPATH, "//app-create-poll-component/div/div[3]/p-card/div/div/div[2]/div/p-button[@label='Back']/button")
    PAGE_2_NEXT = (By.XPATH, "//app-create-poll-component/div/div[3]/p-card/div/div/div[2]/div/p-button[@label='Next']/button")

    PAGE_3_PREVIOUS = (By.XPATH, "//app-create-poll-component/div/div[3]/p-card/div/div/div[2]/div/p-button[@label='Back']/button")

    TITLE = (By.ID, "titre")
    LOCATION = (By.ID, "lieu")
    DESCRIPTION = (By.ID, "desc")

    DATE = (By.XPATH, "//td[contains(@class, 'fc-day-today')]")

    def __init__(self, driver):
        self.driver = driver

    def click_previous(self):
        if self.PAGE_NUMBER == 2:
            self.driver.find_element(*self.PAGE_2_PREVIOUS).click()
        elif self.PAGE_NUMBER == 3:
            self.driver.find_element(*self.PAGE_3_PREVIOUS).click()
        self.PAGE_NUMBER -= 1

    def click_next(self):
        if self.PAGE_NUMBER == 1:
            self.driver.find_element(*self.PAGE_1_NEXT).click()
        elif self.PAGE_NUMBER == 2:
            self.driver.find_element(*self.PAGE_2_NEXT).click()
        self.PAGE_NUMBER += 1

    def set_title(self, title):
        self.driver.find_element(*self.TITLE).send_keys(title)

    def set_location(self, location):
        self.driver.find_element(*self.LOCATION).send_keys(location)

    def set_description(self, description):
        self.driver.find_element(*self.DESCRIPTION).send_keys(description)

    def set_date(self):
        self.driver.find_element(*self.DATE).click()