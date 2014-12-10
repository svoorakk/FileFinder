FileFinder
==========
Code to recursively search a folder for a file. 
- Finds only a exact match of the file name, ignoring case.
- Returns only the first match. 

Depends on 
<pre>
- java.io.File;
- java.io.IOException;
- org.apache.commons.io.FileUtils;
</pre>
Use
===
<pre>
FileFinder ff = new FileFinder();
File fOut = ff.findFile(folderName, fileName);
</pre>

