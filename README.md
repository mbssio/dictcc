<!-- Please be careful editing the below HTML, as GitHub is quite finicky with anything that looks like an HTML tag in GitHub Flavored Markdown. -->
<p align="center">
  <img src="assets/banner.png" alt="Banner">
</p>
<p align="center">
  <b>Simple CLI tool for quick translations using <a href="https://dict.cc">dict.cc</a></b>
</p>
<p align="center">
  <img alt="License Badge" src="https://img.shields.io/github/license/mbssio/dictcc?style=for-the-badge&labelColor=%23363a4f&color=%23a6da95">
  <img alt="GitHub top language" src="https://img.shields.io/github/languages/top/mbssio/dictcc?style=for-the-badge&labelColor=%23363a4f&color=%237dc4e4">
  <img alt="GitHub code size in bytes" src="https://img.shields.io/github/languages/code-size/mbssio/dictcc?style=for-the-badge&labelColor=%23363a4f&color=%23eed49f">
  <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/mbssio/dictcc?style=for-the-badge&labelColor=%23363a4f&color=%23c6a0f6">
</p>

<p>&nbsp;</p>

### (Project WIP)

<p>&nbsp;</p>

## Windows
### Windows Executable (.exe)
Find the executable under releases [here][windows-release] (requires JDK 22+).

Usage:
After executing, the program will prompt the user to enter language codes (dict.cc) followed by the keyword they want to get translated repeatedly.

<p>&nbsp;</p>

## Universal (any OS)
### Java Executable (.jar)
Find the executable under releases [here][universal-release] (requires JDK 22+).

Usage:
Run the program:
```sh
java -jar dictcc.jar
```
After executing, the program will prompt the user to enter language codes (dict.cc) followed by the keyword they want to get translated repeatedly.

Alternatively, the executable accepts arguments in the following order:
- Source language code for translation
- Target language code for translation
- Word that needs to be translated

Example:
```sh
java -jar dictcc.jar en de velocity
```

It is recommended to create an alias for your shell for frequent usage.


[windows-release]: https://github.com/mbssio/dictcc/releases/tag/windows
[universal-release]: https://github.com/mbssio/dictcc/releases/tag/universal
