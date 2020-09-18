package Hash;

public class SHA256 {
	
	private int H[];	//Hacher a l'etape n
	private long n;		//nombre de bloc de 16 integer
	private byte paddingtab[];
	
	private final int k[] = 	{	//Constante utilisé dans SHA 256, 32 premiers bits de la partie décimale des racines cubiques des 64 premiers nombres premiers 
			0x428a2f98, 0x71374491, 0xb5c0fbcf, 0xe9b5dba5, 0x3956c25b, 0x59f111f1, 0x923f82a4, 0xab1c5ed5,
			0xd807aa98, 0x12835b01, 0x243185be, 0x550c7dc3, 0x72be5d74, 0x80deb1fe, 0x9bdc06a7, 0xc19bf174,
			0xe49b69c1, 0xefbe4786, 0x0fc19dc6, 0x240ca1cc, 0x2de92c6f, 0x4a7484aa, 0x5cb0a9dc, 0x76f988da,
			0x983e5152, 0xa831c66d, 0xb00327c8, 0xbf597fc7, 0xc6e00bf3, 0xd5a79147, 0x06ca6351, 0x14292967,
			0x27b70a85, 0x2e1b2138, 0x4d2c6dfc, 0x53380d13, 0x650a7354, 0x766a0abb, 0x81c2c92e, 0x92722c85,
			0xa2bfe8a1, 0xa81a664b, 0xc24b8b70, 0xc76c51a3, 0xd192e819, 0xd6990624, 0xf40e3585, 0x106aa070,
			0x19a4c116, 0x1e376c08, 0x2748774c, 0x34b0bcb5, 0x391c0cb3, 0x4ed8aa4a, 0x5b9cca4f, 0x682e6ff3,
			0x748f82ee, 0x78a5636f, 0x84c87814, 0x8cc70208, 0x90befffa, 0xa4506ceb, 0xbef9a3f7, 0xc67178f2
						};
	
	
/************************************************************************************************/
/*			Constructeurs et procedure public													*/
/************************************************************************************************/
	
	public SHA256(){}	//Constructeur
	
	//Permet de calculer le SHA256 d'une chaine de caractere
	public String SHA256Digest(String mes){
		
		String mesdigest;

		//affecte un tableau de byte a tabmes contenant les valeurs des caracteres de mes
		byte tabmes[] = mes.getBytes(); 
		
		//Initialise et rempli le tableau paddingtab de facon a ce que la longeur total
		//de tabmes + paddingtab soit un multiple de 512
		//de plus paddingtab est rempli avec les specification de SHA 256
		padding(tabmes.length);	
		
		initH();	//Initialise H
		
		mesdigest = sha256computation(tabmes);	//Calcul le condensé
		
		return mesdigest;
		
	}
	
	
/************************************************************************************************/
/*			Fonction SHA256																		*/
/************************************************************************************************/
	//Fonction de traitement des données, calcul le SHA256 des données
	private String sha256computation(byte tabdonne[]){
		int w[] = new int[64];
		int a,b,c,d,e,f,g,h,t1,t2;
		int o=0, l=0;
		
		long modulo =(long) Math.pow(2,32);	//Pour faire les aditions modulo 2^32  
		int len = tabdonne.length;
		for (int i = 0; i < n; i++){
			a = H[0];
			b = H[1];
			c = H[2];
			d = H[3];
			e = H[4];
			f = H[5];
			g = H[6];
			h = H[7];
			
			for (int t= 0; t<64; t++){
				if ( t<16){
					if (o==0){
						if (l + 4 <= len){
							w[t] = 	byte4ToInt(tabdonne[l++],tabdonne[l++],tabdonne[l++],tabdonne[l++]);
						}else if(l + 3 == len) {
							w[t] = 	byte4ToInt(tabdonne[l++],tabdonne[l++],tabdonne[l++],paddingtab[o++]);
						}else if(l + 2 == len) {
							w[t] = 	byte4ToInt(tabdonne[l++],tabdonne[l++],paddingtab[o++],paddingtab[o++]);
						}else if(l + 1 == len) {
							w[t] = 	byte4ToInt(tabdonne[l++],paddingtab[o++],paddingtab[o++],paddingtab[o++]);
						}else{
							w[t] = 	byte4ToInt(paddingtab[o++],paddingtab[o++],paddingtab[o++],paddingtab[o++]);
						}
					}else{
						w[t] = 	byte4ToInt(paddingtab[o++],paddingtab[o++],paddingtab[o++],paddingtab[o++]);
					}
				}else{
					w[t] = sigma1(w[t-2]) + w[t-7] + sigma0(w[t-15]) + w[t-16];
					w[t] = (int)(w[t] % modulo);
				}
				//System.out.println(Integer.toHexString(w[t]));
				t1 = h + sum1(e) + ch(e,f,g) + k[t] + w[t];
				t1 = (int)(t1 % modulo);
				t2 = sum0(a) + maj(a,b,c);
				t2 = (int)(t2 % modulo);
				h = g;
				g = f;
				f = e;
				e = d + t1;
				e = (int)(e % modulo);
				d = c;
				c = b;
				b = a;
				a = t1 + t2;
				a = (int)(a % modulo);
			}
			
			H[0] = (int)((a + H[0]) % modulo);	
			H[1] = (int)((b + H[1]) % modulo);
			H[2] = (int)((c + H[2]) % modulo);
			H[3] = (int)((d + H[3]) % modulo);
			H[4] = (int)((e + H[4]) % modulo);
			H[5] = (int)((f + H[5]) % modulo);
			H[6] = (int)((g + H[6]) % modulo);
			H[7] = (int)((h + H[7]) % modulo);
			
		}
		
		String mesdigest = new String();
		String tmpstring = new String();
		
		for (int i =0;i<8;i++){
			tmpstring = new String();
			tmpstring = Integer.toHexString(H[i]);
			while (tmpstring.length() < 8)
				tmpstring = "0" + tmpstring;
			mesdigest += tmpstring;
		}
		  
		return mesdigest;
	}
	
	//Initialise H avec les valeurs standard pour SHA 256
	private void initH(){
		H = new int[8];
		H[0] = 0x6a09e667;
		H[1] = 0xbb67ae85;
		H[2] = 0x3c6ef372;
		H[3] = 0xa54ff53a;
		H[4] = 0x510e527f;
		H[5] = 0x9b05688c;
		H[6] = 0x1f83d9ab;
		H[7] = 0x5be0cd19;
	}
	
	//Cree un tableau de n case pour complete les données a traiter afin d'obtenir un multiple de 512bits
	private void padding(long length){
		
		int t = 1;
		long len = length * 8;		//nombre de bits dans le message initial
		int k = mod512(448 - (len+1)) / 8;	//nombre de byte a ajouter pour le padding
		
		paddingtab = new byte[k+9];
		
		paddingtab[0] = (byte)0x80;				//on ajoute 1 bit a 1 et le reste a 0
		
		for (int i =0; i < k; i++){
			paddingtab[t++] = (byte)0x0;
		}
		
		long bits = len;			//on ecris la taille du tableau initial sur 64bits
		paddingtab[t++] = (byte)(bits >>> 56);
		paddingtab[t++] = (byte)(bits >>> 48);
		paddingtab[t++] = (byte)(bits >>> 40);
		paddingtab[t++] = (byte)(bits >>> 32);
		paddingtab[t++] = (byte)(bits >>> 24);
		paddingtab[t++] = (byte)(bits >>> 16);
		paddingtab[t++] = (byte)(bits >>> 8);
		paddingtab[t++] = (byte) bits;
		
		n = (length + paddingtab.length) / 64;	//nombre de bloc de 512bits
	}
		
/************************************************************************************************/
/*			Operation sur les mots (1 mot = 32bits = 1 int)										*/
/************************************************************************************************/
	//Rotation à droite des bits de x de m bits
	private int rotr(int m, int x){
		return (x >>> m) | (x << (32 - m));
	}
	
	//Decalage de m bits a droite des bits de x
	private int shr(int m, int x){
		return (x >>> m);	//Decalage a droite de m bits, remplissage à gauche avec des 0
	}
	
/************************************************************************************************/
/*			Fonction logiques utilisées par sha256												*/
/************************************************************************************************/	

	private int ch(int x, int y, int z){
		return (x & y) ^ ((~x) & z); 
	}

	private int maj(int x, int y, int z){
		return (x & y) ^ (x & z) ^ (y & z);
	}
	
	private int sum0(int x){
		return rotr(2,x) ^ rotr(13,x) ^ rotr(22,x);
	}
	
	private int sum1(int x){
		return rotr(6,x) ^ rotr(11,x) ^ rotr(25,x);
	}
	
	private int sigma0(int x){
		return rotr(7,x) ^ rotr(18,x) ^ shr(3,x);
	}
	
	private int sigma1(int x){
		return rotr(17,x) ^ rotr(19,x) ^ shr(10,x);
	}
	
/************************************************************************************************/
/*			fonctions diverses																	*/
/************************************************************************************************/
	
	/**
	 * Implementation du modulo negatif ou positif
	 * @param x mod 512
	 * @return
	 */
	private int mod512 (long x){
		if (x>=0){
			return (int)x % 512;
		}else {
			return (int)(x - 512 *(x/512))+512;
		}
		
	}
	
	private int byte4ToInt(byte b1, byte b2, byte b3, byte b4){
		return 	(b1 & 0xFF) << 24 | 
			(b2 & 0xFF) << 16 | 	
			(b3 & 0xFF) << 8  |
			(b4 & 0xFF);
	}
}
