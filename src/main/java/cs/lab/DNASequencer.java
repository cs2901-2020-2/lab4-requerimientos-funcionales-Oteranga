package cs.lab;

import java.util.List;
import java.util.logging.Logger;

public class  DNASequencer {

    static final Logger logger = Logger.getLogger(DNASequencer.class.getName());
    public DNASequencer() {
        logger.info("Starting sequencer...");
    }

    public String calculate(List<String> parts) throws Largesubex, Muchsubex{

        if(parts.size() > 160000){
            throw new Muchsubex("Too many subseqs");
        }

        for(String it : parts){
            if(it.length() > 200){
                throw new Largesubex("Too large substring");
            }
        }

        //String answer = "";
        StringBuilder answer = new StringBuilder();
        //String subcadena = "";
        StringBuilder subcadena = new StringBuilder();
        int k = 0;

        answer.insert(0,parts.get(0));

        for(int i = 1; i < parts.size(); i++){
            for(int j = 0; j < answer.length(); j++){
                if(answer.charAt(j) == parts.get(i).charAt(k)){
                    subcadena.insert(0, parts.get(i).charAt(k));
                    k++;
                }
            }
            k = 0;
            answer.insert(answer.length(), parts.get(i).substring(subcadena.length()));
            subcadena.delete(0, subcadena.length());
        }

        return answer.toString();
    }
}
