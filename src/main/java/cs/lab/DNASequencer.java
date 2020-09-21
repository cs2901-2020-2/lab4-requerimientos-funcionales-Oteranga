package cs.lab;

import java.util.List;
import java.util.logging.Logger;

public class  DNASequencer {

    static final Logger logger = Logger.getLogger(DNASequencer.class.getName());
    public DNASequencer() {
        logger.info("Starting sequencer...");
    }

    public String calculate(List<String> parts) throws largesubEx, muchsubEx{

        if(parts.size() > 160000){
            throw new muchsubEx("Too many subseqs");
        }

        for(String it : parts){
            if(it.length() > 200){
                throw new largesubEx("Too large substring");
            }
        }

        String answer = "";
        String subcadena = "";
        int k = 0;

        answer += parts.get(0);

        for(int i = 1; i < parts.size(); i++){
            for(int j = 0; j < answer.length(); j++){
                if(answer.charAt(j) == parts.get(i).charAt(k)){
                    subcadena += parts.get(i).charAt(k);
                    k++;
                }
            }
            k = 0;
            answer += parts.get(i).substring(subcadena.length());
            subcadena = "";
        }

        return answer;
    }
}
