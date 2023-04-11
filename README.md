# Aweather

A simple Android mobile client that uses Open Weather API as a source of
weather forecast.

## Compatibility

This application targets Android (6.0) Marshmallow and newer.

## Project Modules

This particular Android project consists of the following modules:

1. **application** - produces Aweather executable application.
2. **base:android** - implements utility features to boost Android application
   development.
3. **base:language** - provides additional features for the Kotlin programming
   language.
4. **base:mvvm** - implements base classes for MVVM architectural pattern and
   data binding.
5. **common:network** - contains an implementation of shared networking features
   such as url interception, SSL handling, exceptions and more.
6. **common:persistence** - a module prepared for cache, storage or database
   shared functionalities (at the moment remains empty).
7. **configuration** - parses the `gradle.properties` and provides injectable
   configuration.
8. **feature:location** - implements Open Weather - Geocoding integration layer.
9. **feature:recent** - implements really simple search history.
10. **feature:weather** - implements Open Weather - Current Weather integration
    layer.
11. **resources** - contains all the reusable Android resources.

## Open Weather API

This application integrates with Open Weather API. In order to work properly,
it is necessary to generate Open Weather API key that allows to authenticate
the client in a service.

More details can be found in the [How to start](https://openweathermap.org/appid)
document.

Once generated, head to the `configuration` module and fill the
`gradle.properties` as it is showcased in a `gradle.properties.sample`.

## Build Types

There are two different build types:

- `debug` - build type with enabled all development tools,
- `release` - build type with disabled all development tools.

## Documentation and configuration

Do not hesitate to consult `settings` directory. You can find there such
directories as:

- `distribute` - contains Firebase App Distribution configuration.
- `keystore` - with signing configuration details,

## Building production

Before building production ensure to:

- change build type to `release`.

This build type uses production configuration files. These files introduces
crucial changes:

- defines proper server connection details (uris, etc.),
- disables development tools,
- configures network requests log level.

## Gradle properties

There are available options that can be configured
in `configuration\gradle.properties` file.

Build type server-related options:

- `OpenWeatherApiUrl<build-type>` - allows to configure server uri.
- `OpenWeatherApiId<build-type>` - allows to configure API key.

> Note that you can find `gradle.properties.sample` file in application modules.
> If you would like to use default values, just copy this file and paste it as
> `gradle.properties`.

After preparing `gradle.properties` file you have to synchronize your Gradle
build. This allows to generate `BuildConfig` class with required constant
variables.
