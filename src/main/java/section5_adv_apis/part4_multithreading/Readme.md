# A FastQC app

## FastQC

FastQ is a sequence format that is used to store the output of high-throughput sequencing instruments such as the 
Illumina HiSeq, NextSeq, and MiSeq platforms.  
The essence of this format is a quality score for each base in the sequence.  

## The challenge

It is you task to create a **multithreaded** application that reads in a (number of) FastQ file(s) and runs an extremely 
basic FastQC analysis. You can choose which parts of the FastQC analysis you want to implement, but at the very least
report the number of sequences, the length of the sequences, and the average quality score and the average quality score per base.

The data folder of this repo already holds a very small FastQ file that you can use for testing.
