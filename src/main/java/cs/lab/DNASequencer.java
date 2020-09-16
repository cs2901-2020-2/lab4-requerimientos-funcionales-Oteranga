package cs.lab;

import java.util.List;
import java.util.logging.Logger;

public class  DNASequencer {

    static final Logger logger = Logger.getLogger(DNASequencer.class.getName());
    public DNASequencer() {
        logger.info("Starting sequencer...");
    }

    public String calculate(List<String> part){
        
        String answer = "";
        String subcadena = "";
        int k = 0;

        answer += part.get(0);

        for(int i = 1; i < part.size(); i++){
            for(int j = 0; j < answer.length(); j++){
                if(answer.charAt(j) == part.get(i).charAt(k)){
                    subcadena += part.get(i).charAt(k);
                    k++;
                }
            }
            k = 0;
            answer += part.get(i).substring(subcadena.length(),part.get(i).length());
            subcadena = "";
        }

        return answer;
    }
}
