import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InstructionLoader {
    public static void main(String[] args) {
        List<String> instructions = loadInstructionsFromFile("instructions.txt");
        List<Long> instructionMemory = new ArrayList<>(1024); // Assuming instruction memory can store 1024 instructions
        
        // Load instructions into instruction memory
        for (String instruction : instructions) {
            long machineCode = Long.parseLong(instruction, 2);
            instructionMemory.add(machineCode);
        }
        
        // Test program to check PC+4 and memory contents
        long pc = 0; // Program Counter
        
        // Print PC+4 and memory contents
        for (long instruction : instructionMemory) {
            System.out.println("PC+4: " + pc);
            System.out.println("Instruction: " + instruction);
            System.out.println("----------------------");
            pc += 4;
        }
    }
    
    private static List<String> loadInstructionsFromFile(String fileName) {
        List<String> instructions = new ArrayList<>();
        
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                instructions.add(line.trim());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        return instructions;
    }
}

