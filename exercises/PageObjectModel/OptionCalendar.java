package org.example.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;

public class OptionCalendar {

    private WebElement dayElement;
    private WebElement calendarCheckboxDay;

    public OptionCalendar(WebElement dayElement) {
        this.dayElement = dayElement;
        this.calendarCheckboxDay = dayElement.findElement(By.className("calendar-checkbox-day"));
    }

    public LocalDateTime startsAt() {
        return null;
    }

    public LocalDateTime endsAt() {
        return null;
    }

    public void select() {
        this.calendarCheckboxDay.click();
    }
}
