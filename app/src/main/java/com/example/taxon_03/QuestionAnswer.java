package com.example.taxon_03;

public class QuestionAnswer {
    public static String question[]={

            "Identify the corrected definition of a package ",
            "When is the finalize() method called?",
           " Where does the system stores parameters and local variables whenever a method is invoked?",
            " Identify the return type of a method that does not return any value.",
            "Identify the modifier which cannot be used for constructor."


    };
   public static String choices[][]={
           {"Package is collection of classes","Package is collection of interface","Package is collection of classes and interface","Package is collection of editing tools"},
           {"Before garbage collection","Before an object goes out of scope","Before a variable goes out of scope","none"},
           {"stack","tree","heap","array"},
           {"int","double","void","null"},
           {"public","private","protected","static"}
   } ;
   public static String correctAnswer[]={
"Package is collection of classes and interface","Before garbage collection","stack","void","static"
   };
}
