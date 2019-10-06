# st-decrypt

Utility for encrypting/decrypting ST-Link firmware images.
It is mostly based on decompiled code, which is not human-readable (and probably never was in the first place).

## Usage
Decrypt binary:

```
$ java -jar st_decrypt.jar --key "encryption key" -i firmware.bin  -o firmware_decrypted.bin
```
Encrypt binary:
```
$ java -jar st_decrypt.jar --key "encryption key" -i firmware.bin  -o firmware_encrypted.bin --encrypt
```

### Usage notes

#### Key? What key? How do I get the key I need?

Finding the key to use might be a bit difficult and often requires analysis of whatever binaries are provided by the vendor to update the device's firmware. A short description of this is mentioned in [@lujii's original blog post](https://lujji.github.io/blog/reverse-engineering-stlink-firmware).

>I used [procyon decompiler](https://bitbucket.org/mstrobel/procyon/downloads), reconstructed function calls and after a while was able to decrypt the firmware binary. Encryption key was ~~“worst HAL libraries”~~ “best performance”. Finally, I’ve hacked everything into a command-line utility, which is able to encrypt and decrypt binary images (code is available on [github](https://github.com/lujji/st-decrypt).

In some cases this may be as simple as running `strings` against the binary. But in other cases more comprehensive unpacking/decomplication of the binary may be needed. Good luck. :)

## Fork info: `fivesixzero/st-decrypt`

### Lineage

This fork was created from [lujii/st-decrypt](https://github.com/lujji/st-decrypt) on October 6th, 2019.

Many thanks to [@lujii](https://github.com/lujji) for their efforts in creating this project. :)

Their blog post describing its origins and use is available on their blog.

<https://lujji.github.io/blog/reverse-engineering-stlink-firmware>

### Purpose

The original project's `jar` didn't include dependencies, which was a bit of a drag when using it locally via bash alias.

### Change 1: Mavenization

The first job of this involved porting the project's structure from the old NetBeans `nbproject` format to a more portable convention-driven Maven structure.

With this completed it should be easier to work with, if the need arises.

No code was changed in the initial port to Maven. Only structure was modified.

## Contributing

### Requirements

* Java `1.8.x` JDK at `$JAVA_HOME` (or `%JAVA_HOME%` if you're Windows-ish)
  * May work right out of the box with newer Java versions
* Maven `mvn` command on path

### Building / Contributing

1. Clone the repo
2. Build via CLI _(if you're into that sort of thing)_
   * `mvn clean package` will generate a pair of `jar` files in `./target`
3. Open in your Maven-aware editor of choice
   * I've used both **IntellJ IDEA** and **VS Code** (with "[Language Support for Java](https://github.com/redhat-developer/vscode-java)" and "[Maven for Java](https://github.com/Microsoft/vscode-maven)" extensions)

### To Do

* ~~Convert to Maven~~
  * Done: b50498a