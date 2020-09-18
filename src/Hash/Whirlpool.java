/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash;

/**
 *
 * @author Mvami N. Jonalex
 */
public class Whirlpool {

//import java.util.*;


//public class Principale {

//	public   void main(String[] args) {
		// TODO Auto-generated method stub
//		char c;
//		String message = new String();
//		String messagpad = new String();
//		String[][] M = new String[8][8];
//		String[][] N = new String[8][8];
//		String[][] T = new String[8][8];
//		Scanner sc = new Scanner(System.in);
//		System.out.print("Entrer un texte: ");
//		message = sc.nextLine();
//		M=whirl(message);
//		System.out.println(" Son haché est: " + affichexa(affichbin(M)));
//		System.out.print("Entrer un autre texte: ");
//		message = sc.nextLine();
//		N=whirl(message);
//		System.out.println(" Son haché est: " + affichexa(affichbin(N)));
//		System.out.print("Entrer un autre texte: ");
//		message = sc.nextLine();
//		T=whirl(message);
//		System.out.println(" Son haché est: " + affichexa(affichbin(T)));
		/*for ( int i = 0; i < M.length; i++ ){
			for ( int j = 0; j < M[i].length; j++ ){
				M[i][j] = "00000000";
			}
		}
		/*for ( int i = 0; i < M.length; i++ ){
			for ( int j = 0; j < M[i].length; j++ ){
				M[i][j] = uSbyte(M[i][j]);
			}
		}*/
		/*M = sByte(M);
		for ( int i = 0; i < M.length; i++ ){
			for ( int j = 0; j < M[i].length; j++ ){
				System.out.print(M[i][j] + "   ");
			}
			System.out.println();
		}
		System.out.println();
		M = mixRow(M);
		for ( int i = 0; i < M.length; i++ ){
			for ( int j = 0; j < M[i].length; j++ ){
				System.out.print(M[i][j] + "   ");
			}
			System.out.println();
		}
		System.out.println();
		N=rConst(2);
		for ( int i = 0; i < M.length; i++ ){
			for ( int j = 0; j < M[i].length; j++ ){
				System.out.print(N[i][j] + "   ");
			}
			System.out.println();
		}*/
		/*System.out.println();
		T = whirl("test");
		for ( int i = 0; i < T.length; i++ ){
			for ( int j = 0; j < T[i].length; j++ ){
				System.out.print(T[i][j] + "   ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println(affichexa(affichbin(T)));
		System.out.println();
		T = whirl("testo");
		for ( int i = 0; i < T.length; i++ ){
			for ( int j = 0; j < T[i].length; j++ ){
				System.out.print(T[i][j] + "   ");
			}
			System.out.println();
		}
		System.out.println(affichexa(affichbin(T)));*/
		/*System.out.println(" Le message est : " + message);
		System.out.println(" La taille du message est : " + message.length());
		System.out.println(" Le message en binaire est : " + chbinaire(message));
		System.out.println(" La taille du message binaire est : " + chbinaire(message).length());
		System.out.println(" Le message nombre de zéro du rembourrage est : " + nbour(message));
		System.out.println(" Le premier rembourrage donne : " + ebour(chbinaire(message),nbour(message)));
		System.out.println(" La longueur du message sur 256 bits est : " + longueur(message));
		System.out.println(" La taille de la longueur du message sur 256 bits est : " + longueur(message).length());
		System.out.println(" Le message après rembourage complet est : " + rembourrage(message));
		System.out.println(" La longueur du message après rembourage complet est : " + rembourrage(message).length());*/
//	}
	
	public String binaire(int n){//Transforme un entier en binaire en stockant dans un String
		if (n==0){
			return "0";
		}
		else{
			String binaire = new String();
			String test = new String();
			int val, m=n;
			while ((m/2)>0){
				val = m%2;
				m = m/2;
				test = test.concat(test.valueOf(val));
			}
			test = test.concat(test.valueOf(1));
			for ( int count = test.length() - 1; count >= 0; count-- ){
				binaire = binaire.concat(binaire.valueOf(test.charAt(count)));
			}
			return binaire;
			}
		}
		
		public   String charbinaire(char c){//Transforme un caractère en son ASCII en stockant dans un String
			int n=(int)c;
			if (n==0){
				return "0";
			}
			else{
				String binaire = new String();
				String test = new String();
				int val, m=n;
				while ((m/2)>0){
					val = m%2;
					m = m/2;
					test = test.concat(test.valueOf(val));
				}
				test = test.concat(test.valueOf(1));
				for ( int count = test.length() - 1; count >= 0; count-- ){
					binaire = binaire.concat(binaire.valueOf(test.charAt(count)));
				}
				return binaire;
				}
		}
		
		public   String chbinaire(String s){//Transforme une chaîne de caractères en son ASCII en stockant dans un String
			String m = new String();
			String bin = new String();
			m=s;
			for ( int count = 0; count < m.length(); count++ ){
				bin = bin.concat(charbinaire(m.charAt(count)));
			}
			return bin;
		}
		
		public   String bour(int n){
			// n représente le nombre de zéro à mettre derrière le 1 pour le remborrage
			String s = new String();
			if (n==0) return s.valueOf(1);
			else{
				String t = new String("0");
				s = "1";
				for ( int count = n; count >= 1; count-- ){
					s = s.concat(t);
				}
				return s;
			}
		}
		
		public   String ebour(String m, int n){
			// m représente la chaîne à rembourer et n le nombre de zéro à mettre derrière le 1 pour le remborrage
			// Cette fonction renvoie le message rembourré
			String s = new String();
			s = m;
			return s.concat(bour(n));
			}
		
		public   int nbour(String m){
			// m représente la chaîne unpadded
			// Cette méthode renvoie le nombre de zéro à mettre dèrrière le 1 pour le rembourrage
			String s = new String();
			s = chbinaire(m);
			int n=s.length();
			if ((n%256==0)&&((n/256)%2==1)) return 511;
			else{
				while(((n%256)!=0)&&(((n/256)%2)!=1)){
					n=n+1;
				}
				return (n-s.length()-1);
			}
		}
		
		public   String longueur (String m){
			//Retourne la longueur sur 256 bits
			String s = new String();
			String trans = new String();
			int n=m.length();
			s = binaire(n);
			trans = "0";
			for ( int count = 1; count <= (256-s.length()-1); count++ ){
				trans = trans.concat("0");
			}
			return trans.concat(s);
		}
		
		public   String rembourrage (String m){
			//Retourne le message rembourré
			String s = new String();
			String s1 = new String();
			String s2 = new String();
			String remb = new String();
			s=m;
			s1 = ebour(chbinaire(s),nbour(s));
			s2 = longueur(s);
			remb = s1.concat(s2);
			return remb;
		}
		
		public   String sbox (int m, int n){
			//Retourne le message rembourré
			String s = new String();
			String so = new String("0");
			int[][] T = new int[16][16];
			T[0][0]=0x18;	T[0][1]=0x23;	T[0][2]=0xc6;	T[0][3]=0xe8;	T[0][4]=0x87;	T[0][5]=0xb8;	T[0][6]=0x01;	T[0][7]=0x4f;	T[0][8]=0x36;	T[0][9]=0xa6;	T[0][10]=0xd2;	T[0][11]=0xf5;	T[0 ][12]=0x79;	T[0][13]=0x6f;	T[0][14]=0x91;	T[0][15]=0x52;
			T[1][0]=0x60;	T[1][1]=0xbc;	T[1][2]=0x9b;	T[1][3]=0x8e;	T[1][4]=0xa3;	T[1][5]=0x0c;	T[1][6]=0x7b;	T[1][7]=0x35;	T[1][8]=0x1d;	T[1][9]=0xe0;	T[1][10]=0xd7;	T[1][11]=0xc2;	T[1][12]=0x2e;	T[1][13]=0x4b;	T[1][14]=0xfe;	T[1][15]=0x57;
			T[2][0]=0x15;	T[2][1]=0x77;	T[2][2]=0x37;	T[2][3]=0xe5;	T[2][4]=0x9f;	T[2][5]=0xf0;	T[2][6]=0x4a;	T[2][7]=0xda;	T[2][8]=0x58;	T[2][9]=0xc9;	T[2][10]=0x29;	T[2][11]=0x0a;	T[2 ][12]=0xb1;	T[2][13]=0xa0;	T[2][14]=0x6b;	T[2][15]=0x85;
			T[3][0]=0xbd;	T[3][1]=0x5d;	T[3][2]=0x10;	T[3][3]=0xf4;	T[3][4]=0xcb;	T[3][5]=0x3e;	T[3][6]=0x05;	T[3][7]=0x67;	T[3][8]=0xe4;	T[3][9]=0x27;	T[3][10]=0x41;	T[3][11]=0x8b;	T[3 ][12]=0xa7;	T[3][13]=0x7d;	T[3][14]=0x95;	T[3][15]=0xd8;
			T[4][0]=0xfb;	T[4][1]=0xee;	T[4][2]=0x7c;	T[4][3]=0x66;	T[4][4]=0xdd;	T[4][5]=0x17;	T[4][6]=0x47;	T[4][7]=0x9e;	T[4][8]=0xca;	T[4][9]=0x2d;	T[4][10]=0xbf;	T[4][11]=0x07;	T[4][12]=0xad;	T[4][13]=0x5a;	T[4][14]=0x83;	T[4][15]=0x33;
			T[5][0]=0x63;	T[5][1]=0x02;	T[5][2]=0xaa;	T[5][3]=0x71;	T[5][4]=0xc8;	T[5][5]=0x19;	T[5][6]=0x49;	T[5][7]=0xd9;	T[5][8]=0xf2;	T[5][9]=0xe3;	T[5][10]=0x5b;	T[5][11]=0x88;	T[5][12]=0x9a;	T[5][13]=0x26;	T[5][14]=0x32;	T[5][15]=0xb0;
			T[6][0]=0xe9;	T[6][1]=0x0f;	T[6][2]=0Xd5;	T[6][3]=0x80;	T[6][4]=0xbe;	T[6][5]=0xcd;	T[6][6]=0x34;	T[6][7]=0x48;	T[6][8]=0xff;	T[6][9]=0x7a;	T[6][10]=0x90;	T[6][11]=0x5f;	T[6][12]=0x20;	T[6][13]=0x68;	T[6][14]=0x1a;	T[6][15]=0xae;
			T[7][0]=0xb4;	T[7][1]=0x54;	T[7][2]=0x93;	T[7][3]=0x22;	T[7][4]=0x64;	T[7][5]=0xf1;	T[7][6]=0x73;	T[7][7]=0x12;	T[7][8]=0x40;	T[7][9]=0x08;	T[7][10]=0xc3;	T[7][11]=0xec;	T[7 ][12]=0xdb;	T[7][13]=0xa1;	T[7][14]=0x8d;	T[7][15]=0x3d;
			T[8][0]=0x97;	T[8][1]=0x00;	T[8][2]=0xcf;	T[8][3]=0x2b;	T[8][4]=0x76;	T[8][5]=0x82;	T[8][6]=0xd6;	T[8][7]=0x1b;	T[8][8]=0xb5;	T[8][9]=0xaf;	T[8][10]=0x6a;	T[8][11]=0x50;	T[8][12]=0x45;	T[8][13]=0xf3;	T[8][14]=0x30;	T[8][15]=0xef;
			T[9][0]=0x3f;	T[9][1]=0x55;	T[9][2]=0xa2;	T[9][3]=0xea;	T[9][4]=0x65;	T[9][5]=0xba;	T[9][6]=0x2f;	T[9][7]=0xc0;	T[9][8]=0xde;	T[9][9]=0x1c;	T[9][10]=0xfd;	T[9][11]=0x4d;	T[9 ][12]=0x92;	T[9][13]=0x75;	T[9][14]=0x06;	T[9][15]=0x8a;
			T[10][0]=0xb2;	T[10][1]=0xe6;	T[10][2]=0x0e;	T[10][3]=0x1f;	T[10][4]=0x62;	T[10][5]=0xd4;	T[10][6]=0xa8;	T[10][7]=0x96;	T[10][8]=0xf9;	T[10][9]=0xc5;	T[10][10]=0x25;	T[10][11]=0x59;	T[10][12]=0x84;	T[10][13]=0x72;	T[10][14]=0x39;	T[10][15]=0x4c;
			T[11][0]=0x5e;	T[11][1]=0x78;	T[11][2]=0x38;	T[11][3]=0x8c;	T[11][4]=0xd1;	T[11][5]=0Xa5;	T[11][6]=0xe2;	T[11][7]=0x61;	T[11][8]=0xb3;	T[11][9]=0x21;	T[11][10]=0x9c;	T[11][11]=0x1e;	T[11][12]=0x43;	T[11][13]=0xc7;	T[11][14]=0xfc;	T[11][15]=0x04;
			T[12][0]=0x51;	T[12][1]=0x99;	T[12][2]=0x6d;	T[12][3]=0x0d;	T[12][4]=0xfa;	T[12][5]=0xdf;	T[12][6]=0x7e;	T[12][7]=0x24;	T[12][8]=0x3b;	T[12][9]=0xab;	T[12][10]=0xce;	T[12][11]=0x11;	T[12][12]=0x8f;	T[12][13]=0x4e;	T[12][14]=0xb7;	T[12][15]=0xeb;
			T[13][0]=0x3c;	T[13][1]=0x81;	T[13][2]=0x94;	T[13][3]=0xf7;	T[13][4]=0xb9;	T[13][5]=0x13;	T[13][6]=0x2c;	T[13][7]=0xd3;	T[13][8]=0xe7;	T[13][9]=0x6e;	T[13][10]=0xc4;	T[13][11]=0x03;	T[13][12]=0x56;	T[13][13]=0x44;	T[13][14]=0x7f;	T[13][15]=0Xa9;
			T[14][0]=0x2a;	T[14][1]=0xbb;	T[14][2]=0xc1;	T[14][3]=0x53;	T[14][4]=0xdc;	T[14][5]=0x0b;	T[14][6]=0x9d;	T[14][7]=0x6c;	T[14][8]=0x31;	T[14][9]=0x74;	T[14][10]=0Xf6;	T[14][11]=0x46;	T[14][12]=0xac;	T[14][13]=0x89;	T[14][14]=0x14;	T[14][15]=0xe1;
			T[15][0]=0x16;	T[15][1]=0x3a;	T[15][2]=0x69;	T[15][3]=0x09;	T[15][4]=0x70;	T[15][5]=0xb6;	T[15][6]=0Xd0;	T[15][7]=0xed;	T[15][8]=0xcc;	T[15][9]=0x42;	T[15][10]=0x98;	T[15][11]=0xa4;	T[15][12]=0x28;	T[15][13]=0x5c;	T[15][14]=0xf8;	T[15][15]=0x86;
			s = binaire(T[m][n]);
			while (s.length()!=8){
				s = so.concat(s);
			}
			return s;
		}
		
		public   int subchaine (String m){//Récupère et donne la valeur décimale des 4 bits de poids fort d'un octet
			String s = new String();
			s = m;
			int sval=0, i=2*2*2;
			for ( int count = 0; count <= 3; count++ ){
				sval=sval + (((int)(s.charAt(count))-48) * i);
				i=i/2;
			}
			return sval;
		}
		
		public   int downchaine (String m){//Récupère et donne la valeur décimale des 4 bits de poids faible d'un octet
			String s = new String();
			s = m;
			int sval=0, i=2*2*2;
			for ( int count = 4; count <= 7; count++ ){
				sval=sval + (((int)(s.charAt(count))-48) * i);
				i=i/2;
			}
			return sval;
		}
		
		public   String uSbyte(String s){//Effectue le substitute bye sur une seule case de la matrice 8*8 d'octets
			String m = new String();
			String res = new String();
			m=s;
			res = sbox(subchaine(m),downchaine(m));
			return res;
		}
		
		public   String[][] sByte(String[][] s){
			String[][] m = new String[8][8];
			for ( int i = 0; i <= 7; i++ ){
				for ( int j = 0; j <= 7; j++ ){
					m[i][j] = uSbyte(s[i][j]);
				}
			}
			return m;
		}
		
		public   String[][] sColumn(String[][] s){
			String[][] m = new String[8][8];
			for ( int i = 0; i <= 7; i++ ){
				for ( int j = 0; j <= 7; j++ ){
					m[i][j] = s[i][j];
				}
			}
			for ( int i = 1; i <= 7; i++ ){
				for ( int j = 0; j <= 7; j++ ){//Attention dans le doc j s'arrete a 6 
					int t = Math.abs((i-j)%8);
					m[i][j] = s[t][j];
				}
			}
			return m;
		}
		
		public   String xor(String s1, String s2){
			String m1 = new String();
			String m2 = new String();
			String result = new String();
			m1=s1;
			m2=s2;
			for ( int count = 0; count <= m1.length()-1; count++ ){
				if (m1.charAt(count)==m2.charAt(count)) result = result.concat("0");
				else result = result.concat("1");
			}
			return result;
		}
		
		public   String decal(String s){
			String m = new String();
			String res = new String();
			m=s;
			res = (m.substring(1, m.length())).concat("0");
			return res;
		}
		
		public   String multi(String s1, String s2){
			String m = new String("100011101");
			String m1 = new String();
			String m2 = new String();
			String res = new String();
			String[] T = new String[8];
			m1="0".concat(s1);
			T[0]=m1;
			m2 = s2;
			int k = 0;
			for ( int count = 1; count <= 7; count++ ){
				T[count] = decal(T[count-1]);
				if (T[count].charAt(0)=='1'){
					T[count] = xor(T[count],m);
				}
			}
			for ( int count = 0; count <= 7; count++ ){
				T[count] = T[count].substring(1,T[count].length());
			}
			for ( int i = 0; i < T.length; i++ ){
			}
			for ( int count = 0; count <= m2.length()-1 ; count++ ){
				if ((m2.charAt(m2.length() - count - 1)=='1')&&(k==0)){
					res = T[count];
					k=1;
				}
				else{
					if(m2.charAt(m2.length() - count - 1)=='1'){
						res = xor(res,T[count]);
					}
				}
			}
			return res;
		}
		
		public  String[][] mixRow (String[][] s) {
			String[][] m = new String[8][8];
			int[][] C = new int[8][8];
			String[][] Cp = new String[8][8];
			String[][] M = new String[8][8];
			C[0][0]=0x1;	C[0][1]=0x1;	C[0][2]=0x4;	C[0][3]=0x1;	C[0][4]=0x8;	C[0][5]=0x5;	C[0][6]=0x2;	C[0][7]=0x9;
			C[1][0]=0x9;	C[1][1]=0x1;	C[1][2]=0x1;	C[1][3]=0x4;	C[1][4]=0x1;	C[1][5]=0x8;	C[1][6]=0x5;	C[1][7]=0x2;
			C[2][0]=0x2;	C[2][1]=0x9;	C[2][2]=0x1;	C[2][3]=0x1;	C[2][4]=0x4;	C[2][5]=0x1;	C[2][6]=0x8;	C[2][7]=0x5;
			C[3][0]=0x5;	C[3][1]=0x2;	C[3][2]=0x9;	C[3][3]=0x1;	C[3][4]=0x1;	C[3][5]=0x4;	C[3][6]=0x1;	C[3][7]=0x8;
			C[4][0]=0x8;	C[4][1]=0x5;	C[4][2]=0x2;	C[4][3]=0x9;	C[4][4]=0x1;	C[4][5]=0x1;	C[4][6]=0x4;	C[4][7]=0x1;
			C[5][0]=0x1;	C[5][1]=0x8;	C[5][2]=0x5;	C[5][3]=0x2;	C[5][4]=0x9;	C[5][5]=0x1;	C[5][6]=0x1;	C[5][7]=0x4;
			C[6][0]=0x4;	C[6][1]=0x1;	C[6][2]=0x8;	C[6][3]=0x5;	C[6][4]=0x2;	C[6][5]=0x9;	C[6][6]=0x1;	C[6][7]=0x1;
			C[7][0]=0x1;	C[7][1]=0x4;	C[7][2]=0x1;	C[7][3]=0x8;	C[7][4]=0x5;	C[7][5]=0x2;	C[7][6]=0x9;	C[7][7]=0x1;
			for ( int i = 0; i <= 7; i++ ){
				for ( int j = 0; j <= 7; j++ ){
					m[i][j] = s[i][j];
				}
			}
			for ( int i = 0; i <= 7; i++ ){
				for ( int j = 0; j <= 7; j++ ){
					Cp[i][j] = complet8(binaire(C[i][j]));
				}
			}
			for ( int i = 0; i <= 7; i++ ){
				for ( int j = 0; j <= 7; j++ ){
					int x=0;
					for ( int k = 0; k <= 7; k++ ){
						if (x==0){
							M[i][j] = multi(m[i][k],Cp[i][k]);
							x=1;
						}
						else M[i][j] = xor(M[i][j],multi(m[i][k],Cp[i][k]));
					}
				}
			}
			return M;
		}
		
		public   String complet8(String s){
			String m = new String();
			String res = new String();
			m=s;
			res = m;
			while (res.length()!=8){
				res = "0".concat(res);
			}
			return res;
		}
		
		public   String[][] aKey (String[][] a,String[][] k){
			String[][] m = new String[8][8];
			String[][] n = new String[8][8];
			String[][] res = new String[8][8];
			for ( int i = 0; i <= 7; i++ ){
				for ( int j = 0; j <= 7; j++ ){
					m[i][j] = a[i][j];
				}
			}
			for ( int i = 0; i <= 7; i++ ){
				for ( int j = 0; j <= 7; j++ ){
					n[i][j] = k[i][j];
				}
			}
			for ( int i = 0; i <= 7; i++ ){
				for ( int j = 0; j <= 7; j++ ){
					res[i][j] = xor(m[i][j],n[i][j]);
				}
			}
			return res;
		}
		
		public   String urConst(int r){
			String s = new String();
			int i=0,compt=0, a=0, b=0;
			while( i <= 7){
				int j=0;
				while(j <= 15){
					compt+=1;
					if (compt==r){
						a=i;
						b=j;
						break;
					}
					j+=1;
				}
				i+=1;
			}
			s=sbox(a,b);
			return s;
		}
		
		public   String[][] rConst (int n){
			String[][] m = new String[8][8];
			for ( int i = 0; i <= 7; i++ ){
				for ( int j = 0; j <= 7; j++ ){
					if (i==0) m[i][j] = urConst(8*(n-1)+j);
					else m[i][j] = complet8("0");
				}
			}
			return m;
		}
		
		public   int nbrebloc(String s){
			String m = new String();
			m = s;
			int n;
			n=m.length();
			n=n/512;
			return n;
		}
		
		public   String[][] rFunction(String[][] text,String[][] key){
			String[][] m = new String[8][8];
			String[][] n = new String[8][8];
			String[][] res = new String[8][8];
			for ( int i = 0; i <= 7; i++ ){
				for ( int j = 0; j <= 7; j++ ){
					m[i][j] = text[i][j];
				}
			}
			for ( int i = 0; i <= 7; i++ ){
				for ( int j = 0; j <= 7; j++ ){
					n[i][j] = key[i][j];
				}
			}
			res = mixRow(sColumn(sByte(aKey(m, n))));
			return res;
		}
		
		public   String[][] rKey(String[][] rc){
			String[][] m = new String[8][8];
			String[][] res = new String[8][8];
			for ( int i = 0; i <= 7; i++ ){
				for ( int j = 0; j <= 7; j++ ){
					m[i][j] = rc[i][j];
				}
			}
			res = mixRow(sColumn(sByte(m)));
			return res;
		}
		
		public   String[][] W(String[][] text,String[][] ko){
			String[][] m = new String[8][8];
			String[][] n = new String[8][8];
			String[][] key = new String[8][8];
			String[][] keyo = new String[8][8];
			String[][] res = new String[8][8];
			for ( int i = 0; i <= 7; i++ ){
				for ( int j = 0; j <= 7; j++ ){
					m[i][j] = text[i][j];
				}
			}
			for ( int i = 0; i <= 7; i++ ){
				for ( int j = 0; j <= 7; j++ ){
					n[i][j] = ko[i][j];
				}
			}
			for ( int i = 0; i <= 7; i++ ){
				for ( int j = 0; j <= 7; j++ ){
					keyo[i][j] = ko[i][j];
				}
			}
			int x=0;
			for ( int i = 0; i <= 10; i++ ){
					if(x==0){
						res = rFunction(m, n);
						x=1;
						key = rConst(1);
					}
					else{
						n = aKey(rKey(keyo), key);
						res = rFunction(res, n);
						keyo = n;
						key = rConst(i+1);
					}
			}
			return res;
		}
		
		public   String[][] divisechaine(String s){
			String[][] res = new String[8][8];
			String m = new String();
			m=s;
			int d=0,f=8;
			for ( int i = 0; i <= 7; i++ ){
				for ( int j = 0; j <= 7; j++ ){
					res[i][j] = m.substring(d, f);
					d = f;
					f = f + 8;
				}
			}
			return res;
		}
		
		public   String[][] whirl (String s){
			String[][] res = new String[8][8];
			String[][] mres = new String[8][8];
			String[][] temp = new String[8][8];
			String[][] ho = new String[8][8];
			String m = new String();
			String rembour = new String();
			m = s;
			rembour = rembourrage(m);
			for ( int i = 0; i < ho.length; i++ ){
				for ( int j = 0; j < ho[i].length; j++ ){
					ho[i][j] = "00000000";
				}
			}
			int x=0;
			for ( int i = 1; i <= nbrebloc(rembour); i++ ){
				if(x==0){
					temp = W(divisechaine(rembour.substring(rembour.length() - 512, rembour.length())),ho);
					for ( int k = 0; k <= 7; k++ ){
						for ( int j = 0; j <= 7; j++ ){
							res[k][j] = xor(temp[k][j],divisechaine(rembour.substring(rembour.length() - 512, rembour.length()))[k][j]);
						}
					}
					for ( int k = 0; k <= 7; k++ ){
						for ( int j = 0; j <= 7; j++ ){
							res[k][j] = xor(res[k][j],ho[k][j]);
						}
					}
					x=1;
				}
				else{
					temp = W(divisechaine(rembour.substring(rembour.length() - i*512, rembour.length()-(i-1)*512)),res);
					for ( int k = 0; k <= 7; k++ ){
						for ( int j = 0; j <= 7; j++ ){
							mres[k][j] = xor(temp[k][j],divisechaine(rembour.substring(rembour.length() - i*512, rembour.length()-(i-1)*512))[k][j]);
						}
					}
					for ( int k = 0; k <= 7; k++ ){
						for ( int j = 0; j <= 7; j++ ){
							res[k][j] = xor(res[k][j],mres[k][j]);
						}
					}
				}
			}
			return res;
		}
		
		public   String affichbin (String[][] s){
			String res = new String();
			String[][] m = new String[8][8];
			int x = 0;
			for ( int i = 0; i <= 7; i++ ){
				for ( int j = 0; j <= 7; j++ ){
					m[i][j] = s[i][j];
				}
			}
			for ( int i = 0; i <= 7; i++ ){
				for ( int j = 0; j <= 7; j++ ){
					if (x==0){
						res = m[i][j];
						x = 1;
					}
					else res = res.concat(m[i][j]);
				}
			}
			return res;
		}
		
		public   String hexa(String s){
			String m = new String();
			m=s;
			if (m.compareTo("0000")==0) return "0";
			if (m.compareTo("0001")==0) return "1";
			if (m.compareTo("0010")==0) return "2";
			if (m.compareTo("0011")==0) return "3";
			if (m.compareTo("0100")==0) return "4";
			if (m.compareTo("0101")==0) return "5";
			if (m.compareTo("0110")==0) return "6";
			if (m.compareTo("0111")==0) return "7";
			if (m.compareTo("1000")==0) return "8";
			if (m.compareTo("1001")==0) return "9";
			if (m.compareTo("1010")==0) return "A";
			if (m.compareTo("1011")==0) return "B";
			if (m.compareTo("1100")==0) return "C";
			if (m.compareTo("1101")==0) return "D";
			if (m.compareTo("1110")==0) return "E";
			return "F";
		}
		
		public   String affichexa(String s){
			String m = new String();
			String res = new String();
			m=s;
			res = hexa(m.substring(0,4));
			for ( int i = 4; i <= m.length() - 4; i+=4 ){
				res = res.concat(hexa(m.substring(i, i+4)));
			}
			return res;
		}
		
}
