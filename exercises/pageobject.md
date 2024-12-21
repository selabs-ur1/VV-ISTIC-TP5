## Page Object Model

The image below shows the poll page of the [Simba Organizer](https://github.com/barais/doodlestudent/) application discussed in classes.

![Simba Organizer Poll page](simba-poll-page.png)

Write in this document the interface of a page object class for this page.

## Answer


```python
from selenium.webdriver.common.by import By
from selenium.webdriver.remote.webdriver import WebDriver


class SimbaPollPage:
    def __init__(self, driver: WebDriver):
        self.driver = driver

    # Locators
    PARTICIPANT_NAME_FIELD = (By.ID, "participantName")  # Assuming ID is participantName
    PARTICIPANT_EMAIL_FIELD = (By.ID, "participantEmail")  # Assuming ID is participantEmail
    ACCESSIBLE_AGENDA_CHECKBOX = (By.XPATH, "//input[@type='checkbox'][@name='agendaAccessible']")
    DIETARY_PREFERENCES_FIELD = (By.XPATH, "//textarea[@name='dietaryPreferences']")
    TIME_SLOT_TABLE = (By.XPATH, "//table[@class='time-slot-table']")  # Assuming the class of the table
    SUBMIT_VOTE_BUTTON = (By.XPATH, "//button[contains(text(),'Soumettre vos')]")
    COMMENT_BOX = (By.ID, "commentBox")  # Assuming ID is commentBox
    ADD_COMMENT_BUTTON = (By.XPATH, "//button[contains(text(),'Ajouter commentaire')]")

    # Methods
    def enter_participant_name(self, name: str):
        self.driver.find_element(*self.PARTICIPANT_NAME_FIELD).send_keys(name)

    def enter_participant_email(self, email: str):
        self.driver.find_element(*self.PARTICIPANT_EMAIL_FIELD).send_keys(email)

    def toggle_accessible_agenda(self, enable: bool):
        checkbox = self.driver.find_element(*self.ACCESSIBLE_AGENDA_CHECKBOX)
        if checkbox.is_selected() != enable:
            checkbox.click()

    def set_dietary_preferences(self, preferences: str):
        self.driver.find_element(*self.DIETARY_PREFERENCES_FIELD).send_keys(preferences)

    def select_time_slot(self, row: int, column: int):
        # Assuming the table cells are clickable for selection
        table = self.driver.find_element(*self.TIME_SLOT_TABLE)
        cell = table.find_element(By.XPATH, f"//tr[{row}]/td[{column}]")
        cell.click()

    def submit_vote(self):
        self.driver.find_element(*self.SUBMIT_VOTE_BUTTON).click()

    def add_comment(self, comment: str):
        self.driver.find_element(*self.COMMENT_BOX).send_keys(comment)
        self.driver.find_element(*self.ADD_COMMENT_BUTTON).click()
```
