import java.util.Scanner;

public class Data
{
  Scanner sc = new Scanner(System.in);

	private int dia;
	private int mes;
	private int ano;

	public Data()
	{
    
	}

  public Data(int d,int m,int a){
    dia = d;
    mes = m;
    ano = a;
    
    while(mes!=2){
      if(dia>=1 || dia<=31){
        if((dia==30 && mes == 4 || mes == 6 || mes == 9 || mes == 11) || 
        (dia==31 && mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12))
        {
          if(mes==12){
             this.dia = 1;
             this.mes = 1;
             this.ano = this.ano + 1;
             System.out.println(this.dia + "/" + this.mes + "/" + this.ano);
             break;
          }
          else{
            this.dia = 1;
            this.mes = this.mes + 1;
            System.out.println(this.dia + "/" + this.mes + "/" + this.ano);
            break;
          }
        }
        else{
          if(dia>31 && mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12)
          {
            System.out.println("Dia Inválido");
            break;
          } 
          else if(dia>30 && mes == 4 || mes == 6 || mes == 9 || mes == 11) 
          {
            System.out.println("Dia Inválido");
            break;
          }
          else{
            this.dia = this.dia + 1;
            System.out.println(this.dia + "/" + this.mes + "/" + this.ano);
            break;
          }
        }
      }
    }
    
    while(mes==2){
      if(dia>=1 || dia<=28){
        if(dia==27){
          this.dia = 1;
          this.mes = this.mes + 1;
          System.out.println(this.dia + "/" + this.mes + "/" + this.ano);
          break;
        }
        else{
          if(dia>27){
            System.out.println("Dia Inválido");
            break;
          }
          else{
            this.dia = this.dia + 1;
            System.out.println(this.dia + "/" + this.mes + "/" + this.ano);
            break;
          }
        }
      }
    }
  }

  public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAno() {
		return ano;
	}

  public boolean eAnoBissexto(int a) {
		if ((ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0))) {
			return true;
		} else {
			return false;
		}
	}

  public int daysMonth(int m) {
		if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
			return 31;
		} else {
			if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
				return 30;
			} else {
				if (eAnoBissexto(m) == false) {
					return 28;
				} else {
					return 29;
				}
			}
		}
	}

  public void aPartirDe1900(int ano){
    if(ano >= 1900){
      this.ano = ano;
      System.out.println(this.dia + "/" + this.mes + "/" + this.ano);
    }
    else{
      System.out.println("Data Inválida");
    }
  }

  public void AdicionaDias(int dias){
    dia = 31;
    mes = 10;
    ano = 2020;

    if(dias<=0){
      return;
    }

    this.dia = this.dia + dias;

    while(this.dia > 30 && mes == 4 || mes == 6 || mes == 9 || mes == 11){
      this.dia = this.dia - 30;
      this.mes++;
      System.out.println(this.dia + "/" + this.mes + "/" + this.ano); 
    }

    while(this.dia > 31 && mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
      this.dia = this.dia - 31;
      this.mes++;

      if(this.mes > 12){
        this.ano++;
        this.mes = 1;
        System.out.println(this.dia + "/" + this.mes + "/" + this.ano);
      }
      else{
        System.out.println(this.dia + "/" + this.mes + "/" + this.ano);
      }
    }
  }

  public int difDias(int d, int m, int a) 
	{
		int day = 0, month = 0, year = 0;
		
		int r = 0;

		int dm1 = 0, dm2 = 0;

		if(a == ano)
		{
			if(m == mes)
			{
				if(d == dia)
				{
					System.out.println("Os dias são iguais.");
				}
				else
				{
					if(d > dia)
					{
						day = d - dia;
					}
					else
					{
						day = dia - d;
					}
				}
				return day;
			}
			else
			{
				for(int i=0;i<m;i++)
				{
					dm1 = dm1 + daysMonth(i);
				}
				for(int i=0;i<mes;i++)
				{
					dm2 = dm2 + daysMonth(i);
				}
				if(dm1 > dm2)
				{
					month = dm1 - dm2;
					if(d == dia)
					{
						return month + dia;
					}
					else
					{
						if(d > dia)
						{
							day = d - dia;
						}
						else
						{
							day = dia - d;
						}
						return month + day;
					}
				}
				else
				{
					month = dm2 - dm1;
					if(d == dia)
					{
						return month + dia;
					}
					else
					{
						if(d > dia)
						{
							day = d - dia;
						}
						else
						{
							day = dia - d;
						}
						return month + day;
					}
				}
			}
		}
		else
		{
			if(a > ano)
			{
				if(a - ano != 1)
				{
					for(int i = ano; i < a; i++)
					{
						if(eAnoBissexto(i))
						{
							year = year + 366;
						}
						else
						{
							year = year + 365;
						}
					}
				}
				if(m == mes)
				{
					if(d == dia)
					{
						r = 365;
					}
					else
					{
						if(d > dia)
						{
							day = d - dia;
						}
						else
						{
							day = dia - d;
						}
					}
					r = 365 - day;
				}
				else
				{
					for(int i=0;i<m;i++)
					{
						dm1 = dm1 + daysMonth(i);
					}
					for(int i=0;i<mes;i++)
					{
						dm2 = dm2 + daysMonth(i);
					}
					if(dm1 > dm2)
					{
						month = dm1 - dm2;
						if(d == dia)
						{
							r = month + dia;
						}
						else
						{
							if(d > dia)
							{
								day = d - dia;
							}
							else
							{
								day = dia - d;
							}
							r = month + day;
						}
					}
					else
					{
						month = dm2 - dm1;
						if(d == dia)
						{
							r = month + dia;
						}
						else
						{
							if(d > dia)
							{
							  day = d - dia;
							}
							else
							{
								day = dia - d;
							}
							r = month + day;
						}
					}
				}
			return -(year + r) + 365;
		}
		else
		{
			if(ano - a != 1)
			{
				for(int i = a; i < ano; i++)
				{
					if(eAnoBissexto(i))
					{
						year = year + 366;
					}
					else
					{
						year = year + 365;
					}
				}
			}
			if(m == mes)
			{
				if(d == dia)
				{
					r = 365;
				}
				else
				{
					if(d > dia)
					{
						day = d - dia;
					}
					else
					{
						day = dia - d;
					}
				}
				r = 365 - day;
			}
			else
			{
				for(int i=0;i<m;i++)
				{
					dm1 = dm1 + daysMonth(i);
				}
				for(int i=0;i<mes;i++)
				{
					dm2 = dm2 + daysMonth(i);
				}
				if(dm1 > dm2)
				{
					month = dm1 - dm2;
					if(d == dia)
					{
						r = month + dia;
					}
					else
					{
						if(d > dia)
						{
							day = d - dia;
						}
						else
						{
							day = dia - d;
						}
						r = month + day;
					}
				}
				else
				{
					month = dm2 - dm1;
					if(d == dia)
					{
						r = month + dia;
					}
					else
					{
						if(d > dia)
						{
							day = d - dia;
						}
						else
						{
							day = dia - d;
						}
						r = month + day;
					}
				}
			}
		}
		return -(year + r) + 365;
	}
}

   public void DataMaisRecente(){

     int dia1,mes1,ano1;
     
     int dia2,mes2,ano2;

     System.out.println("1º Dia:");
     dia1 = sc.nextInt();
     System.out.println("1º Mes:");
     mes1 = sc.nextInt();
     System.out.println("1º Ano:");
     ano1 = sc.nextInt();

     System.out.println("2º Dia:");
     dia2 = sc.nextInt();
     System.out.println("2º Mes:");
     mes2 = sc.nextInt();
     System.out.println("2º Ano:");
     ano2 = sc.nextInt();

     if(ano1 == ano2)
		 {
			 if(mes1 == mes2)
			 {
				 if(dia1 == dia2)
				 {
			     System.out.println("As datas são iguais.");
				 }
				 else
				 {
					 if(dia1>dia2)
					 {
				     System.out.println("A 1ª data é mais recente.");
					 }
					 if(dia2>dia1)
					 {
				     System.out.println("A 2ª data é mais recente.");
					 }
				 }
			 }
			 else
			 {
				 if(mes1>mes2)
				 {
			     System.out.println("A 1ª data é mais recente.");
				 }
				 if(mes2>mes1)
				 {
			     System.out.println("A 2ª data é mais recente.");
				 }
			 }
		 }
		 else
		 {
			 if(ano1>ano2)
			 {
		     System.out.println("A 1ª data é mais recente.");
			 }
			 if(ano2>ano1)
			 {
		     System.out.println("A 2ª data é mais recente.");
			 }
		 }
	}
}
