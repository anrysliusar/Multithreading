# Multithreading
### Task
Create a file and fill it with some content (lorem ipsum or some article from somewhere, not the essence). Write a LineStorage class that will have a String field. Write a ContentReader class that will read the contents of the file in the stream and write each line to a LineStorage object. Write a ContentPrinter class that will display LineStorage content in the console. Synchronize it so that ContentPrinter does not display the same string multiple times.
#### Additional tasks
* Rewrite ContentPrinter so that it not only displays on the console, but also rewrites the text to another file.
* Create another class, WordWriter, which will parse a line of text from LineStorage, break it into individual words and write them to another file
