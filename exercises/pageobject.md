## Page Object Model

The image below shows the poll page of the [Simba Organizer](https://github.com/barais/doodlestudent/) application discussed in classes.

![Simba Organizer Poll page](simba-poll-page.png)

Write in this document the interface of a page object class for this page.

## Answer

La page object model a été réalisé en python.

```
class SimbaOrganizerPage:
    def __init__(self, driver):
        self.driver = driver


    # Locators
    BUTTON_NEW = (By.XPATH, "//button[text()='Nouveau']")
    BUTTON_SHARE = (By.XPATH, "//button[text()='Partager']")
    BUTTON_CHAT = (By.XPATH, "//button[text()='Chat']")
    BUTTON_PAD = (By.XPATH, "//button[text()='Pad']")
    PROJECT_TITLE = (By.XPATH, "//h1[text()='Projet Quickstart Session']")
    PROJECT_CREATED_INFO = (By.XPATH, "//p[contains(text(),'Créé il y a 1 minute')]")
    LOCATION_INFO = (By.XPATH, "//p[contains(text(),'Main Hall')]")
    MEAL_INFO = (By.XPATH, "//p[contains(text(),'Cet événement contient un repas')]")
    PARTICIPANT_NAME = (By.NAME, 'participantName')
    PARTICIPANT_EMAIL = (By.NAME, 'participantEmail')
    QUESTION_SWITCH_1 = (By.XPATH, "//span[text()='Question 1']/following-sibling::label/span")
    QUESTION_SWITCH_2 = (By.XPATH, "//span[text()='Question 2']/following-sibling::label/span")
    DATE_TIME_PICKER = (By.ID, 'datetimepicker')
    SUBMIT_BUTTON = (By.XPATH, "//button[text()='Soumettre Vœux']")
    AUTHOR_NAME = (By.NAME, 'authorName')
    COMMENT_SECTION = (By.XPATH, "//textarea[@name='comment']")
    ADD_COMMENT_BUTTON = (By.XPATH, "//button[text()='Ajouter un Commentaire']")


    # Methodes pour interragir avec la page
    def click_new_button(self):
        self.driver.find_element(*self.BUTTON_NEW).click()


    def click_share_button(self):
        self.driver.find_element(*self.BUTTON_SHARE).click()


    def click_chat_pad_button(self):
        self.driver.find_element(*self.BUTTON_CHAT).click()


    def click_chat_pad_button(self):
        self.driver.find_element(*self.BUTTON_PAD).click()


    def get_project_title(self):
        return self.driver.find_element(*self.PROJECT_TITLE).text


    def get_created_info(self):
        return self.driver.find_element(*self.PROJECT_CREATED_INFO).text


    def get_location_info(self):
        return self.driver.find_element(*self.LOCATION_INFO).text


    def get_meal_info(self):
        return self.driver.find_element(*self.MEAL_INFO).text


    def enter_participant_name(self, name):
        self.driver.find_element(*self.PARTICIPANT_NAME).send_keys(name)


    def enter_participant_email(self, email):
        self.driver.find_element(*self.PARTICIPANT_EMAIL).send_keys(email)


    def toggle_question_switch_1(self):
        self.driver.find_element(*self.QUESTION_SWITCH_1).click()


    def toggle_question_switch_2(self):
        self.driver.find_element(*self.QUESTION_SWITCH_2).click()


    def select_date_time(self, date_time):
        date_time_picker = self.driver.find_element(*self.DATE_TIME_PICKER)
        date_time_picker.clear()
        date_time_picker.send_keys(date_time)


    def click_submit_button(self):
        self.driver.find_element(*self.SUBMIT_BUTTON).click()


    def enter_author_name(self, author_name):
        self.driver.find_element(*self.AUTHOR_NAME).send_keys(author_name)


    def enter_comment(self, comment):
        self.driver.find_element(*self.COMMENT_SECTION).send_keys(comment)


    def click_add_comment_button(self):
        self.driver.find_element(*self.ADD_COMMENT_BUTTON).click()

```
