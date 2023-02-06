# Year-11-CS-Unit-6-Lab-VigenereCipher

Your job is to create one class called VigenereCipher.
You should pass all of the tests in the VigenereCipherTester class (provided).



The Vigenère cipher is a classic cipher originally developed by Italian cryptographer Giovan Battista Bellaso and published in 1553. It is named after a later French cryptographer Blaise de Vigenère, who had developed a stronger autokey cipher (a cipher that incorporates the message of the text into the key).

The cipher is easy to understand and implement, but survived three centuries of attempts to break it, earning it the nickname "le chiffre indéchiffrable" or "the indecipherable cipher."

From Wikipedia:

The Vigenère cipher is a method of encrypting alphabetic text by using a series of different Caesar ciphers based on the letters of a keyword. It is a simple form of polyalphabetic substitution.

In a Caesar cipher, each letter of the alphabet is shifted along some number of places; for example, in a Caesar cipher of shift 3, A would become D, B would become E, Y would become B and so on. The Vigenère cipher consists of several Caesar ciphers in sequence with different shift values.

Assume the key is repeated for the length of the text, character by character. Note that some implementations repeat the key over characters only if they are part of the alphabet -- this is not the case here.










VigenereCipher will consist of two properties: a key and an alphabet. The alphabet will be a String that consists of the letters a-zA-Z. The purpose of alphabet is to check if a character in the message that is to be encoded or decoded is a valid character to be encrypted or not. 

VigenereCipher will have a single constructor that takes the key as an argument. The constructor will initialize both properties.

VigenereCipher will have getters and setters for the key. 

VigenereCipher will contain two methods - encode and decode. Note that you are free to implement more methods if you wish to do so. Perhaps including a helper method or two will allow you to better understand the problem, debug your code more easily, and improve the readability of your code, which together makes it more manageable. Decomposition is essential to computer science.

VigenereCipher vc = new VigenereCipher(“lemon”);

String encodedMessage = vc.encode(“attackatdawn”);

System.out.println(encodedMessage); // lxfopvefrnhr

String decodedMessage = vc.decode(“lxfopvefrnhr”);

System.out.println(decodedMessage); // attackatdawn


String anotherEncodedMessage = vs.encode(“attack!atdawn”);

System.out.println(anotherEncodedMessage); // lxfopv!mhqlaz


String anotherDecodedMessage = vs.decode(“lxfopv!mhqlaz”);

System.out.println(anotherDecodedMessage); // attack!atdawn

Work with lowercase letters. That is, convert the key to lowercase when it is initialized, and the encoded or decoded message should only display lowercase letters.

String aFurtherEncodedMessage = vc.encode(“attackAtdaWn”);

System.out.println(aFurtherEncodedMessage); // lxfopvefrnhr

Name: Camille

Partner: None
