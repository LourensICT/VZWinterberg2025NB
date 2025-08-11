# Notebook Android App

Een moderne Android notitieboek app geschreven in Kotlin met de volgende functionaliteiten:

## 🚀 Features

- **Text Notes**: Tekstnotities met rich text formatting (vet, cursief, etc.)
- **Location Notes**: Locatie notities met GPS coördinaten en custom namen
- **Photo Notes**: Foto notities met meerdere afbeeldingen en slideshow functionaliteit
- **Modern UI**: Clean en moderne Material Design interface
- **Local Storage**: Room database voor lokale opslag
- **MVVM Architecture**: Model-View-ViewModel pattern voor gestructureerde ontwikkeling

## 🛠️ Technische Details

- **Language**: Kotlin
- **Architecture**: MVVM (Model-View-ViewModel)
- **Database**: Room Persistence Library
- **UI**: Material Design Components
- **Image Loading**: Glide
- **Location Services**: Google Play Services Location
- **Rich Text**: RichEditor Android library
- **Minimum SDK**: 24 (Android 7.0)
- **Target SDK**: 33 (Android 13)

## 📋 Vereisten

- Java 17 of hoger
- Android SDK
- Node.js 18+ (voor npm scripts)

## 🚀 Setup

### Automatische Setup

```bash
# Clone het project
git clone <repository-url>
cd notebook-android-app

# Run de setup script
npm run setup
```

### Handmatige Setup

1. **Java 17 installeren**:
   ```bash
   sudo apt update
   sudo apt install -y openjdk-17-jdk
   ```

2. **Android SDK installeren**:
   ```bash
   mkdir -p ~/Android/Sdk
   cd ~/Android/Sdk
   wget https://dl.google.com/android/repository/commandlinetools-linux-11076708_latest.zip
   unzip commandlinetools-linux-11076708_latest.zip
   mkdir -p cmdline-tools/latest
   mv cmdline-tools/* cmdline-tools/latest/ 2>/dev/null || true
   
   export ANDROID_HOME=~/Android/Sdk
   export PATH=$PATH:$ANDROID_HOME/cmdline-tools/latest/bin
   
   yes | sdkmanager --licenses
   sdkmanager "platform-tools" "platforms;android-33" "build-tools;33.0.0"
   ```

3. **Gradle wrapper downloaden**:
   ```bash
   ./setup-android.sh
   ```

## 📦 NPM Scripts

Deze app gebruikt npm scripts voor eenvoudige project management:

```bash
# Setup Android development environment
npm run setup

# Clean project build files
npm run clean

# Build the Android project
npm run build

# Install/refresh dependencies
npm run install-deps

# Run tests
npm run test

# Run linting
npm run lint

# Build APK
npm run assemble

# Install APK to device
npm run install

# Show help
npm run help
```

## 🏗️ Project Structuur

```
app/
├── src/main/
│   ├── java/com/example/notebook/
│   │   ├── data/           # Database, DAO, Repository
│   │   ├── ui/             # Adapters, ViewModels
│   │   ├── MainActivity.kt # Hoofdactiviteit
│   │   └── AddNoteActivity.kt # Notitie toevoegen activiteit
│   ├── res/
│   │   ├── layout/         # UI layouts
│   │   ├── values/         # Strings, colors, themes
│   │   └── drawable/       # Icons en graphics
│   └── AndroidManifest.xml
├── build.gradle           # App-level build configuratie
└── proguard-rules.pro     # ProGuard regels

build.gradle              # Project-level build configuratie
gradle.properties         # Gradle properties
settings.gradle          # Project settings
```

## 🔧 Build Configuratie

- **Gradle Version**: 7.5
- **Android Gradle Plugin**: 7.4.2
- **Kotlin Version**: 1.8.0
- **Compile SDK**: 33
- **Target SDK**: 33
- **Min SDK**: 24

## 📱 Permissions

De app vraagt de volgende permissions:

- `CAMERA`: Voor het maken van foto's
- `READ_EXTERNAL_STORAGE`: Voor het lezen van afbeeldingen
- `WRITE_EXTERNAL_STORAGE`: Voor het opslaan van afbeeldingen
- `ACCESS_FINE_LOCATION`: Voor GPS locatie
- `ACCESS_COARSE_LOCATION`: Voor netwerk locatie
- `INTERNET`: Voor Google Play Services
- `POST_NOTIFICATIONS`: Voor Android 13+ notificaties

## 🎨 UI Features

- **Material Design**: Moderne UI componenten
- **RecyclerView**: Efficiënte lijst weergave
- **ViewBinding**: Type-safe view toegang
- **FloatingActionButton**: Voor het toevoegen van notities
- **CardView**: Voor notitie items
- **Rich Text Editor**: Voor tekst formatting

## 🗄️ Database Schema

```kotlin
@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val content: String,
    val type: NoteType,
    val createdAt: Date,
    val updatedAt: Date,
    val latitude: Double?,
    val longitude: Double?,
    val locationName: String?,
    val imagePaths: String? // JSON array van image paths
)
```

## 🔄 Toekomstige Uitbreidingen

- [ ] Rich text editing voor tekst notities
- [ ] Photo slideshow functionaliteit
- [ ] Filtering op notitie type
- [ ] Map view voor locatie notities
- [ ] Search functionaliteit
- [ ] Cloud backup
- [ ] Notitie delen
- [ ] Tags en categorieën
- [ ] Dark mode
- [ ] Widgets

## 🐛 Troubleshooting

### Java Version Issues
```bash
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH
```

### Android SDK Issues
```bash
export ANDROID_HOME=~/Android/Sdk
export PATH=$PATH:$ANDROID_HOME/cmdline-tools/latest/bin:$ANDROID_HOME/platform-tools
```

### Gradle Issues
```bash
./gradlew clean
./gradlew --refresh-dependencies
```

## 📄 License

MIT License - zie LICENSE bestand voor details.

## 🤝 Contributing

1. Fork het project
2. Maak een feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit je wijzigingen (`git commit -m 'Add some AmazingFeature'`)
4. Push naar de branch (`git push origin feature/AmazingFeature`)
5. Open een Pull Request

## 📞 Support

Voor vragen of problemen, open een issue in de GitHub repository.
