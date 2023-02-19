package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public List<String> readNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        return strip(Arrays.asList(input.split(",")));
    }

    public int readHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }

    public List<String> readResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        return strip(Arrays.asList(input.split(",")));
    }

    public String askResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine().strip();
    }

    private List<String> strip(List<String> inputs) {
        return inputs.stream()
                .map(String::strip)
                .collect(Collectors.toList());
    }
}
