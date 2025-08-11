# Notebook Android App

Een moderne Android notitieboek app geschreven in Kotlin met ondersteuning voor tekst, locatie en foto notities.

## Functies

### 📝 Tekst Notities
- Rijke tekst ondersteuning (vetgedrukt, cursief, etc.)
- Titel en beschrijving
- Automatische datum/tijd stamp

### 📍 Locatie Notities
- Huidige locatie ophalen
- Aangepaste locatienaam
- GPS coördinaten opslaan

### 📸 Foto Notities
- Camera integratie
- Meerdere foto's per notitie
- Slideshow weergave
- Automatische formaat aanpassing

### 🎨 Moderne UI
- Material Design
- Card-based layout
- Smooth animaties
- Responsive design

## Technische Details

### Architectuur
- **MVVM Pattern** met ViewModel en LiveData
- **Room Database** voor lokale opslag
- **Repository Pattern** voor data management
- **ViewBinding** voor type-safe view access

### Dependencies
- **Room**: Lokale database
- **Glide**: Image loading en caching
- **Google Play Services**: Location services
- **Material Components**: UI componenten
- **Navigation Component**: Screen navigation

### Permissions
- Camera toegang voor foto's
- Locatie toegang voor GPS
- Storage toegang voor bestanden

## Setup

1. **Clone het project**
   ```bash
   git clone <repository-url>
   cd notebook
   ```

2. **Open in Android Studio**
   - Open Android Studio
   - Selecteer "Open an existing project"
   - Navigeer naar de project folder

3. **Sync Gradle**
   - Wacht tot Gradle sync is voltooid
   - Los eventuele dependency issues op

4. **Run de app**
   - Verbind een Android device of start een emulator
   - Klik op "Run" (groene play button)

## Project Structuur

```
app/src/main/
├── java/com/example/notebook/
│   ├── data/           # Database entiteiten en DAO's
│   ├── ui/             # ViewModels en Adapters
│   ├── MainActivity.kt # Hoofdactiviteit
│   └── AddNoteActivity.kt # Notitie toevoegen
├── res/
│   ├── layout/         # XML layouts
│   ├── drawable/       # Icons en graphics
│   ├── values/         # Strings, colors, themes
│   └── xml/           # Configuratie bestanden
└── AndroidManifest.xml
```

## Gebruik

1. **Notitie Toevoegen**
   - Tap de + knop rechtsonder
   - Kies type: Text, Location, of Photo
   - Vul titel en beschrijving in
   - Voor locatie: geef een naam op
   - Voor foto's: neem foto's met de camera
   - Tap "Save Note"

2. **Notities Bekijken**
   - Alle notities staan op de hoofdpagina
   - Nieuwste notities bovenaan
   - Tap op een notitie voor details

3. **Foto Slideshow**
   - Bij foto notities met meerdere foto's
   - Swipe links/rechts om door foto's te navigeren

## Toekomstige Uitbreidingen

- [ ] Kaartweergave voor locatie notities
- [ ] Filtering op notitie type
- [ ] Zoekfunctionaliteit
- [ ] Cloud backup
- [ ] Delen van notities
- [ ] Tags en categorieën
- [ ] Dark mode

## Licentie

Dit project is gemaakt als educatief voorbeeld.
