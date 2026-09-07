# Converter & Pixel System

CS240 Assignment 1 — represents information as bits: ASCII characters, number bases, and image pixels.

## Status

1. Build an ASCII-to-decimal converter. **Complete** (`AsciiDecimalConverter.java`)
2. Build a number-base converter supporting binary, decimal, octal, and hexadecimal. **Complete** (`NumberBaseConverter.java`)
3. Write a program that reads an image and prints its pixel values. **Complete** (`ImageToPixels.java`)
4. Write a program that consumes pixel values and creates an image. **Complete** (`PixelsToImage.java`)
5. Test boundary cases, including zero, the largest supported unsigned value, and at least one negative two's-complement value. **Complete** (see Testing below)

## How to run

`Main.java` only runs one program at a time. Open it and uncomment the two lines for whichever program you want, making sure the other pairs stay commented out:

```java
NumberBaseConverter numBaseconverter = new NumberBaseConverter();
numBaseconverter.prompt();
```

Then compile and run from this folder:

```
javac Main.java -d bin
java -cp bin Main
```

- **AsciiDecimalConverter**: enter a string, prints each character's decimal (ASCII) value.
- **NumberBaseConverter**: enter a number, choose the base you're converting from and to (binary/decimal/octal/hex).
- **ImageToPixels**: reads `smileImage.png` from this folder and prints every pixel as an `(r, g, b)` value.
- **PixelsToImage**: enter a width, height, and a string of color letters (`r`=red, `g`=green, `y`=yellow, `w`=white, `b`=black, `o`=orange), one letter per pixel, no spaces, read left-to-right/top-to-bottom. Enter a file name and it writes a new PNG to this folder.

## Testing

Boundary cases for part 5 were tested through `NumberBaseConverter`:

- **Zero**: decimal `0` → binary → `0`.
- **Largest supported unsigned value**: hex `ffffffff` (4294967295 unsigned) → decimal → `-1`. Since the converter stores values in a signed 32-bit `int`, this value overflows and wraps to its two's-complement negative equivalent.
- **Negative two's-complement value**: the `-1` result above is that negative case — `-1` and `4294967295` are the same 32 bits, interpreted as signed vs. unsigned.

`ImageToPixels` and `PixelsToImage` were tested functionally: reading `smileImage.png` and printing its pixels, and generating a new PNG from typed color values.

## Acknowledgments

Developed with AI assistance (Claude Code) for code review, debugging, and testing guidance. As well as organizing and making the README and PDF look good and contain all necessary information.
