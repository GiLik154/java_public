package example2;

public class Disp {

		//�Ϲ� ����.
		String x = "x";
		
		////	static ����	////
		//final Ű���带 ���̸� ������ ����� ��. ó���� ���� ���� ���� ���� �� �ٲ�.
		//��� ��� ���� = �̸��� �� �빮�ڷ� ��.
		final static String DOT = "��";	
		public static void line() {
//			Cw.w(x);	// �Ϲ� ��� ������ ����.
			for(int i=0;i<40;i=i+1) {
				Cw.w(DOT);	// static ��� ������ ��� ����.
			}
			Cw.wn("");
		}
		
		public static void title() {
			line();
			Cw.wn("************** ����� ī��   ***************");
			line();
		}

	}

