package eventClean.example.EventClean.core.usecases;

import java.util.Random;

public class GerarIndentificadorUseCaseImpl implements GerarIdentificadorUseCase{
    @Override
    public String execute() {
        Random random = new Random();
        StringBuilder characters = new StringBuilder();

        int digits = random.nextInt(900) + 100;

        for (int i = 1; i<=4; i++){
            char c = (char)(random.nextInt(26)+ 'a');
            characters.append(c);
        }

        return characters.toString().toUpperCase() + digits;
    }
}
