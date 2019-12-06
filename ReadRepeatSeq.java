


// awk -F "\t" '{if($3-$2 <50){print $1"\t"$2-30"\t"$3+40}else{print}}' msi_s_add50.bed > new_3add.bed
// /root/bedtools2/bin/fastaFromBed -fi /data/reference_fasta/hg19.fasta -bed new_3add.bed -tab -fo msi_seqs.fa


import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Collections;
import java.util.Comparator;
import java.io.File;
import java.io.FileNotFoundException;


public class ReadRepeatSeq {

	public static void main(String[] args) throws Exception {
		srctxtReader("msi_seqs.fa");

	}

	public static void srctxtReader(String fileName){
		File txtFile = new File(fileName);

		String line;
		int seqLen;
		String s;
		if (txtFile.isFile() && txtFile.exists()) {   
			try {
				Scanner sc = new Scanner(txtFile, "utf-8");
				// StringBuffer sb = new StringBuffer();
				while (sc.hasNextLine()) { 
					// sb.append(scanner.nextLine()).toString();
					// System.out.println(sb.toString());

					line = sc.nextLine();
					//String[] splitStrs = line.split("\\\t");
					//System.out.println(splitStrs.length);
					String[] splitStrs = line.split("\\s{1,}");
					s = splitStrs[1];
					seqLen = s.length(); 

					s = s.toUpperCase();
					HashMap<String, Integer> baseCount = new HashMap<String, Integer>();
					for (int s_start = 0; s_start < seqLen -6; s_start++) {
						int s_end = s_start + 35;
						String s1;
						if (s_end >= seqLen){
							s1 = s.substring(s_start, seqLen-1);
						    
						}else{
							s1 = s.substring(s_start, s_end);
						}
						int j = 1;
						for (int i=1; i<s1.length();i++ ){
							if(s1.charAt(i) == s1.charAt(0)){
								j++;
							}else{
								break;
							}
						}
						if(j >= 6){
							baseCount.put( splitStrs[0] +"\t" + s1.substring(0, j), j);
                            // System.out.println(s1.substring(0, j));    
						}    
						
					}
					Set<Entry<String, Integer>> set = baseCount.entrySet();
					ArrayList<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
					Collections.sort( list, new Comparator<Map.Entry<String, Integer>>(){
						public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 ){
							return (o2.getValue()).compareTo( o1.getValue() );   //Descending order
						}
					} );
					for(Map.Entry<String, Integer> entry:list){
						System.out.println(entry.getKey()+" ==== "+entry.getValue());
					}
					// ref :  https://stackoverflow.com/questions/109383/sort-a-mapkey-value-by-values
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}    
		}
	}
}
            
