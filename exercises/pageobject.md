## Page Object Model

The image below shows the poll page of the [Simba Organizer](https://github.com/barais/doodlestudent/) application discussed in classes.

![Simba Organizer Poll page](simba-poll-page.png)

Write in this document the interface of a page object class for this page.

## Answer

```python
class PollPage:
    def set_name (self, driver, name):
        pass
    
    def set_email (self, driver, email):
        pass
    
    def set_ics_url (self, driver, ics_url):
        pass
    
    def food_choice (self, driver, choice):
        pass
    
    def set_date (self, driver, date):
        pass
    
    def set_comment_name (self, driver, name):
        pass
    
    def set_comment_data (self, driver, data):
        pass

```