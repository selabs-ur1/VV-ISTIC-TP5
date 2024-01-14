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

Code réalisant les étapes du random wiki walker

```
import time
import random
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium import webdriver
from selenium.webdriver.common.by import By


# Initialisation du navigateur Chrome en utilisant le chemin du pilote et les options
driver = webdriver.Chrome()
driver.implicitly_wait(5)
driver.maximize_window()


# Fonction pour prendre une capture d'écran et la sauvegarder
def take_screenshot(page_number):
    # Changer le chemin pour l'enregistrer à l'endroit voulu
    screenshot_path = r"C:\Users\natyu\Documents\School\M2 IL\VV TP\VV-TP5-Selenium\screenshot_{}.png".format(page_number)
    driver.save_screenshot(screenshot_path)
    return screenshot_path


# Appeler l’application web
driver.get("https://fr.wikipedia.org/wiki/Wikip%C3%A9dia:Accueil_principal")
driver.implicitly_wait(5)


# Nombre de pages à visiter
pages_to_visit = 10


for page_number in range(1, pages_to_visit + 1):
    all_links = driver.find_elements(By.TAG_NAME, 'a')


    if all_links:
        num_links = len(all_links)
        random_index = random.randint(0, num_links - 1)
        random_link = all_links[random_index]


        print("Random index :", random_index)
        print("Mot cliqué:", random_link.text)


        # Scroll jusqu'à l'élément pour le rendre visible
        driver.execute_script("arguments[0].scrollIntoView(true);", random_link)


        # Attendre un court instant pour s'assurer que l'élément est rendu visible
        time.sleep(1)


        # Cliquer sur l'élément en utilisant JavaScript
        driver.execute_script("arguments[0].click();", random_link)


        time.sleep(2)
# Prendre une capture d'écran de la dernière page
screenshot_path = take_screenshot(pages_to_visit)
print(f"Last page captured. Saved as {screenshot_path}")


# Fermer la fenêtre du navigateur
driver.quit()

```

Voici une capture d'écran que l'on peut obtenir en lançant le script
![screenshot_10.png](https://github.com/Natyuu/VV-ISTIC-TP5/blob/main/screenshot_10.png)
