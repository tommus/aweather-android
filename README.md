# Aweather :sunny: :cloud:

A simple Android mobile client that utilizes the Open Weather API as a source of
weather forecasts.

## Compatibility :iphone:

This application is designed for Android 6.0 (Marshmallow) and newer versions.

## Project Modules :file_folder:

This Android project is structured into the following modules:

1. **application** - Generates the Aweather executable application.
2. **base:android** - Implements utility features to enhance Android app
   development.
3. **base:language** - Provides additional features for the Kotlin programming
   language.
4. **base:mvvm** - Implements base classes for the MVVM architectural pattern
   and data binding.
5. **common:network** - Contains shared networking features like URL
   interception, SSL handling, and more.
6. **common:persistence** - Prepared for cache, storage, or database shared
   functionalities (currently empty).
7. **configuration** - Parses `gradle.properties` and provides injectable
   configuration.
8. **feature:location** - Implements Open Weather - Geocoding integration layer.
9. **feature:recent** - Implements simple search history functionality.
10. **feature:weather** - Implements Open Weather - Current Weather integration
    layer.
11. **resources** - Contains all reusable Android resources.

## Open Weather API :earth_americas:

This application integrates with the Open Weather API. To function correctly,
you need to generate an Open Weather API key for client authentication.

For more details, refer to the [How to Start](https://openweathermap.org/appid)
guide.

After generating the API key, navigate to the `configuration` module and fill in
the `gradle.properties` as demonstrated in `gradle.properties.sample`.

## Build Types :hammer:

Two build types are available:

- `debug` - Enables all development tools.
- `release` - Disables all development tools.

## Documentation and Configuration :page_facing_up:

Check the `settings` directory for additional information, including:

- `distribute` - Contains Firebase App Distribution configuration.
- `keystore` - Signing configuration details.

## Building for Production :construction_worker:

Before building for production:

- Change the build type to `release`.

The `release` build type uses production configuration files that introduce
crucial changes:

- Define proper server connection details (URIs, etc.).
- Disable development tools.
- Configure network request log level.

## Gradle Properties :gear:

You can configure several options in the `configuration\gradle.properties` file:

Build type server-related options:

- `OpenWeatherApiUrl<build-type>` - Configure server URI.
- `OpenWeatherApiId<build-type>` - Configure API key.

> Note: Find the `gradle.properties.sample` file in application modules. For
> default values, copy and rename this file to `gradle.properties`.

After preparing the `gradle.properties` file, sync your Gradle build to generate
the required `BuildConfig` class with constant variables.
