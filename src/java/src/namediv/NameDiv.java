package namediv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NameDiv {
	final String name = "이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,전경헌";
	final String[] splitName = name.split(",");
	int kim = 0;
	int lee = 0;
	int young = 0;

	public static void main(String[] args) {
		NameDiv result = new NameDiv();
		
		result.searchName();
		
		List<String>distinctLiName = result.distinctLi();
		
		result.sort(distinctLiName);
		
	}

	void searchName() {
		for (int i = 0; i < splitName.length; i++) {
			if (splitName[i].startsWith("김")) {
				kim++;
			} else if (splitName[i].startsWith("이")) {
				lee++;
			}
			if (splitName[i].startsWith("이재영")) {
				young++;
			}
		}
		System.out.println(kim + "명");
		System.out.println(lee + "명");
		System.out.println("이재영은" + young + "명");
	}

	
	ArrayList<String> distinctLi() {
		List<String> arrName = Arrays.asList(splitName);
		List<String> distinctLi = arrName.stream().distinct().collect(Collectors.toList());

		ArrayList<String> distinctLiName = new ArrayList<>(distinctLi);
		System.out.println(distinctLiName);

		return distinctLiName;
	}

	
	
	void sort(List<String>distinctLiName) {
		ArrayList<String> sortName = new ArrayList<>(distinctLiName);
		sortName.sort(Comparator.naturalOrder());
		System.out.println(sortName);
	}
}
