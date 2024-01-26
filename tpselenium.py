from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.keys import Keys
import time
import random

# Fonction pour prendre un instantané de la page actuelle
def prendre_capture_ecran(navigateur, nom_fichier):
    navigateur.save_screenshot(nom_fichier)

# URL de la page principale de Wikipedia
url_depart = "https://www.wikipedia.org/"

# Nombre de pages à visiter
nombre_pages_a_visiter = 10

# Initialisation du navigateur
navigateur = webdriver.Chrome()
navigateur.get(url_depart)

try:
    for _ in range(nombre_pages_a_visiter):
        # Sélection d'un lien aléatoire
        liens = navigateur.find_elements(By.TAG_NAME, "a")
        lien_aleatoire = random.choice(liens)

        # Utilisation de JavaScript pour cliquer sur le lien
        navigateur.execute_script("arguments[0].click();", lien_aleatoire)

        # Attendre que certains éléments de la nouvelle page se chargent
        attente = WebDriverWait(navigateur, 10)
        attente.until(EC.presence_of_element_located((By.TAG_NAME, "body")))

        time.sleep(2)

    # Prendre un instantané de la dernière page visitée
    prendre_capture_ecran(navigateur, "capture_derniere_page.png")

except Exception as e:
    print(f"Une erreur s'est produite : {str(e)}")

finally:
    # Fermer le navigateur à la fin
    navigateur.quit()
