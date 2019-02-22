
This code is tested only for reading file in the same folder in project, and can be tested in future for more features.

 Steps
 1) Scan file name present in the same directory
 2) Use Bufferedreader to read text from a characters input stream
 3) Initialize a map where we will store words as keys and their count as value.* 4) If words is read first time, its value will be set to 1 (its count will be 1)
 5) Before adding new word, we will make it lowercase to avoid the case matching
 6) Before adding a new word, we will check if it exist in map (by using it as key and fetching the value)
 7) Then we will use streams:----
       a) In this we will have chain of some steps
      b) First we will take entryset of map and will convert it into a stream (it is a sequence of objects)
       c) Then we will use Map.Entry.comparingByValue() which will sort Entry on the basis of value (in ascending order)
       d) To reverse the sequence in descending order we will use Collections.reverseOrder
       e) To keep only 10 elements in stream we will use limit method with 10.
       f) Then we will use the collect method where we will pass two functions one operator and one supplier(where we want to store the
       number of values given my limit). Here we used method references
      g) finally we will iterate through map and print it
