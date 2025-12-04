# 📚 ReVoid Library

![GitHub Workflow Status (with event)](https://img.shields.io/github/actions/workflow/status/cupul-miu-04/revoid-library/release.yml)
![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)

Library containing common utilities for ReVoid.

## ❓ About

ReVoid Library is a custom implementation based on ReVanced Library, providing common utilities and functionalities.

## 💪 Features

Some of the features the ReVoid Library provides are:

- 📝 **Signing APKs**: Read and write keystores, and sign APK files
- 🧩 **Common utility functions**: Various APIs for patches such as JSON serialization,
  reading and setting patch options, calculating the most common compatible version for a set of patches and more
- 💾 **Install and uninstall APKs**: Install and uninstall APK files via ADB or locally,
  the Android package manager, or by mounting using root permissions
- 📦 **Repackage patched files to an APK**: Apply patched files from
  ReVoid Patcher to an APK file, and align & sign the APK file automatically

## 🚀 How to get started

To use ReVoid Library in your project, follow these steps:

1. Add the repository to your project:

   ```kotlin
   repositories {
       maven {
           url = uri("https://maven.pkg.github.com/cupul-miu-04/revoid-library")
           credentials {
               username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_ACTOR")
               password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
           }
       }
   }
```

1. Add the dependency to your project:
   ```kotlin
   dependencies {
       implementation("com.revoid:revoid-library:{$version}")
   }
   ```

📚 Project Structure

· Branches:
  · master - Stable releases
  · dev - Development branch
  · revoid-maven-proxy - Branch with package namespace changes

📙 Contributing

Thank you for considering contributing to ReVoid Library.
You can find the contribution guidelineshere.

🛠️ Building

To build ReVoid Library from source:

```bash
# Clone the repository
git clone https://github.com/cupul-miu-04/revoid-library.git
cd revoid-library

# Build the project
./gradlew build
```

📜 License

ReVoid Library is licensed under the GPLv3 license. Please see the license file for more information.

🔗 Related Projects

· ReVoid Patcher - Patcher library used by ReVoid

```

## **Notas sobre los cambios realizados:**

### **1. Sección principal:**
- Removido el banner con logos de ReVanced
- Removidos todos los enlaces sociales de ReVanced
- Cambiado "ReVanced Library" → "ReVoid Library" en todo el documento
- Actualizado badge de GitHub Actions a tu repositorio

### **2. Sección "About":**
- Cambiada la descripción para reflejar que es una implementación custom
- Removidas referencias a ReVanced Manager y ReVanced CLI

### **3. Sección "Features":**
- Mantenido el contenido técnico (son características genéricas)
- Cambiada referencia a "ReVoid Patcher" en lugar de "ReVanced Patcher"

### **4. Sección "How to get started":**
- Actualizado el código de ejemplo con tu repositorio de GitHub Packages
- Cambiado `app.revanced:revanced-library` → `com.revoid:revoid-library`
- Incluido ejemplo completo de configuración del repositorio

### **5. Nueva sección "Project Structure":**
- Añadida para explicar las ramas que configuraste

### **6. Sección "Building":**
- Simplificada con comandos básicos
- Removida referencia a documentación de ReVanced

### **7. Sección "Related Projects":**
- Añadida referencia a tu fork de ReVoid Patcher

## **Opciones adicionales:**

Si quieres agregar logos de ReVoid en el futuro, puedes:

1. Crear logos y colocarlos en `assets/revoid-headline/` y `assets/revoid-logo/`
2. Agregar una sección similar al original:

```markdown
<p align="center">
  <picture>
    <source
      width="256px"
      media="(prefers-color-scheme: dark)"
      srcset="assets/revoid-headline/revoid-headline-vertical-dark.svg"
    >
    <img 
      width="256px"
      src="assets/revoid-headline/revoid-headline-vertical-light.svg"
    >
  </picture>
  <br>
  <a href="https://github.com/cupul-miu-04">
    <picture>
      <source height="24px" media="(prefers-color-scheme: dark)" srcset="https://i.ibb.co/dMMmCrW/Git-Hub-Mark.png" />
      <img height="24px" src="https://i.ibb.co/9wV3HGF/Git-Hub-Mark-Light.png" />
    </picture>
  </a>
  <br>
  <br>
  Custom implementation based on ReVanced
</p>
```

Comando para verificar que no queden referencias a ReVanced:

```bash
# Verificar referencias restantes a ReVanced en README.md
grep -i "revanced" README.md

# Verificar URLs de GitHub
grep -i "github.com" README.md
```