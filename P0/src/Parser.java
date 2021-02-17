import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Parser 
{
	public static void main(String[] args) throws Exception 
	{
		boolean valido = true; 
		File f = new File("data/Comandos.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		String st = br.readLine();
		ArrayList<String> comandos = new ArrayList<>();
		ArrayList<String> variables = new ArrayList<>();
		while(st != null && valido)
		{
			if(!st.startsWith("(walk") || !st.startsWith("(rotate")||!st.startsWith("(look")||!st.startsWith("(drop")||!st.startsWith("(free")||!st.startsWith("(pick")||!st.startsWith("(grab")||!st.startsWith("(walkTo")||!st.startsWith("(define")||!st.startsWith("(NOP")||!st.startsWith("(if")||!st.startsWith("(block"))
			{
				System.out.println("Inválido");
				valido = false; 
			}
			else
			{
				if (st.startsWith("(walk") || st.startsWith("(drop")||st.startsWith("(free")||st.startsWith("(pick") || st.startsWith("(grab"))
				{
					boolean esVariable = false; 
					String[] palabras = st.split(" ");
					String valor = palabras[1];
					for(int i = 0; i < variables.size(); i++)
					{
						String act = variables.get(i);
						if(act.equals(valor))
						{
							esVariable = true;
						}
					}
					if(!esVariable)
					{
						try
						{
							Integer num = Integer.parseInt(valor);
						}
						catch (Exception e) 
						{
							System.out.println("Invalido");
							valido = false; 
						}				
					}
				}
				else if(st.startsWith("(rotate"))
				{
					String[] rotate = st.split(" ");
					String direccion = rotate[1];
					if(!direccion.equals("left")||!direccion.equals("right")||!direccion.equals("back"))
					{
						System.out.println("Invalido");
						valido = false;
					}

				}
				else if(st.startsWith("(look"))
				{
					String[] look = st.split(" ");
					String cardinal = look[1];
					if(!cardinal.equals("N")||!cardinal.equals("E")||!cardinal.equals("W")||!cardinal.equals("S"))
					{
						System.out.println("Invalido");
						valido = false;
					}

				}
				else if(st.startsWith("(walkTo"))
				{
					boolean esVariable = false; 
					String[] palabras = st.split(" ");
					String valor = palabras[1];
					for(int i = 0; i < variables.size(); i++)
					{
						String act = variables.get(i);
						if(act.equals(valor))
						{
							esVariable = true;
						}
					}
					if(!esVariable)
					{
						try
						{
							Integer num = Integer.parseInt(valor);
						}
						catch (Exception e) 
						{
							System.out.println("Invalido");
							valido = false; 
						}					
					}
					String direccion = palabras[2];
					if(!direccion.equals("N")||!direccion.equals("E")||!direccion.equals("W")||!direccion.equals("S"))
					{
						System.out.println("Invalido");
						valido = false; 
					}
				}
			}
			st = br.readLine();
		}
		br.close();
		if(valido)
		{
			System.out.println("Valido");
		}
	}
}
