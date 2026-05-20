#SecureStorageLabJava
analyste:souaid med amine
Application Android en Java démontrant la **persistance locale sécurisée des données** sans connexion Internet.  
Ce projet implémente plusieurs méthodes de stockage tout en respectant des **bonnes pratiques de sécurité**.

---

## Objectifs

- Utiliser `SharedPreferences` pour les données non sensibles
- Sécuriser un token avec `EncryptedSharedPreferences`
- Lire/écrire des fichiers internes (texte + JSON)
- Gérer un cache temporaire
- Utiliser le stockage externe app-specific
- Appliquer des règles de sécurité strictes

---

##echnologies

- Java (Android)
- Android SDK (min API 24)
- AndroidX Security Crypto
- JSON (`org.json`)

---

##Installation

```bash
git clone https://github.com/TON_USERNAME/SecureStorageLabJava.git
Ouvrir avec Android Studio
Sync Gradle
Lancer l'application
📦 Dépendance principale
implementation "androidx.security:security-crypto:1.1.0-alpha06"
🧩 Fonctionnalités
🔹 SharedPreferences

Stockage de :

Nom
Langue
Thème
apply() → asynchrone
commit() → synchrone
 EncryptedSharedPreferences
Stockage sécurisé du token
Utilisation de MasterKey
Chiffrement AES256

 Le token :

 jamais loggé
 jamais affiché
 seule sa longueur est utilisée
 Stockage interne
Fichier texte (note.txt)
JSON (students.json)
Encodage UTF-8

Emplacement :

/data/data/<package>/files/
 Cache
Fichier temporaire (last_ui.txt)
Suppression avec purge()

Emplacement :

/data/data/<package>/cache/
 Stockage externe (app-specific)
Export de fichier
Pas de permission requise
Accessible uniquement par l’app
 Interface
Champs : nom, langue, thème, token
Boutons :
Sauvegarder prefs
Charger prefs
Sauvegarder JSON
Charger JSON
Effacer
 Fonctionnement
Saisie des données utilisateur
Sauvegarde des préférences
Chiffrement du token
Création des fichiers internes
Lecture après redémarrage
Nettoyage complet avec "Effacer"
 Vérification
 Données persistantes après redémarrage
 Aucun token dans Logcat
Fichiers visibles via Device File Explorer
Cache supprimé correctement
 Sécurité
Données sensibles chiffrées
MODE_PRIVATE utilisé
Aucun log sensible
Nettoyage complet implémenté
Cache uniquement temporaire
UTF-8 pour tous les fichiers
Token masqué (password)
 Checklist
 Aucun token en clair
 EncryptedSharedPreferences utilisé
 MODE_PRIVATE respecté
 Nettoyage complet
 Cache purgé
 Stockage externe sécurisé
 Exceptions gérées
 UTF-8 utilisé
 Token non affiché
 Vérification fichiers OK
