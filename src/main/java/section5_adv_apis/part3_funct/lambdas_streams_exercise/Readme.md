# Lambdas and Streams exercise

1. Within class `LambdasStreamExercise`, implement method `dnaToAbbreviatedNames`. 
   Create a stream of the given DNA sequence and convert it into a String representation that 
   is a sequence of the first three letters of the name of each nucleotide, separated by dots.
   For example, the sequence "ACG" should return "Ade.Cyt.Gua". 
   You may assume regular DNA is passed as argument (e.g. DNA_ONE or DNA_TWO). Implement these 
   individual steps in your stream:  
   
   - Start with `DNA.chars()` to initiate a Stream. This will be one of integers.
   - Convert the integers into Nucleotide objects (use casting and `mapToObj()`)
   - Convert Nucleotide instances in String objects
   - Concatenate the strings to a single one
   
2. Within class `LambdasStreamExercise`, implement method `dnaToWeight` in order to determine 
   the molecular weight of a DNA sequence string from its nucleotides. Implement these 
   individual steps in your stream:  
     
   - Start with `DNA.chars()` to initiate a Stream. This will be one of integers.
   - Filter out those that do not represent regular DNA (Challenge: and count them)
   - Convert to a stream of Character objects from the given DNA sequence
   - Convert the Characters into Nucleotide objects
   - Convert the Nucleotide objects to their weights
   - Sum the weights and return the result (And report the number of rejected nucleotides)

3. Within class `LambdasStreamExercise`, implement method `countNucleotide` to count the occurrence
   of a given nucleotide in a DNA sequence. Implement these individual steps in your stream:  
   
   - Start with `DNA.chars()` to initiate a Stream. This will be one of integers.
   - Convert the integers into Nucleotide objects (use casting and `mapToObj()`)
   - Filter those of the correct type
   - Count them
     

You can run the tests in class `LambdasStreamExerciseTest` to verify the correctness of your solution. 


4. In package `section5_adv_apis.part3_funct.lambdas_streams_exercise` you will find class `SNPstreams` that contains two method
   stubs to be implemented.
 
   * Using field `SNP_COLLECTION`, implement method `getDiseaseCandidateSnps`. It should output
   the SNPs with a minor allele frequency between 0.0001 and 0.1, as CSV formatted String.  
   Output should be something like this:

        ```
         100275;A;C;0.00323
         162889;C;G;8.72E-4
         676255;G;C;0.0016672
         667280;A;G;0.00287
         719876;C;A;0.006649
        ```
   * Using field `SNP_DATA`, implement method `getTransversionsTransitions`. It should return a Map.
   Keys of this Map should be the Strings "transversion" and "transition", and the values of the Map should be
   lists of SNP objects. "Transitions" are changes between A<->G and C<->T and "transversions"
   are changes A<->C, G<->T, A<->T and C<->G.

