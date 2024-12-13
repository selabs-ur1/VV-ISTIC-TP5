public class PollPage {
    private WebDriver driver;

    public PollPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getParticipantNameField() {
        return driver.findElement(By.name("Nom prénom participant"));
    }

    public WebElement getParticipantEmailField() {
        return driver.findElement(By.name("Email participant"));
    }

    public void setParticipantName(String name) {
        getParticipantNameField().sendKeys(name);
    }

    public void setParticipantEmail(String email) {
        getParticipantEmailField().sendKeys(email);
    }

    public boolean isDietaryPreferencesCheckboxPresent() {
        return driver.findElement(By.name("Avez vous des préférences alimentaires ?")).isDisplayed();
    }

    public void clickCalendarView() {
        driver.findElement(By.cssSelector("button[aria-label='Vue Calendrier']")).click();
    }

    public void clickTableView() {
        driver.findElement(By.cssSelector("button[aria-label='Vue Tableau']")).click();
    }

    public List<String> getEventTimes() {
        List<WebElement> timeCells = driver.findElements(By.cssSelector("table td:nth-child(1)"));
        return timeCells.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public int getParticipantCount() {
        return driver.findElements(By.cssSelector("table tr")).size() - 1; // Exclude header row
    }
}