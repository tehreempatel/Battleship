
import java.util.ArrayList;
import java.util.Scanner;


public class TestClass {



 public static void main(String[] args) {
Scanner in=new Scanner(System.in);//crée un nouveau scanner nommé in
int boatStrength=0;//variable qui détermine la stabilité du bateau

ArrayList allColumnHits=new ArrayList<Integer>();//crée une nouvelle liste qui va contenir toutes les colonnes où la personne à deviné
ArrayList allRowHits=new ArrayList<Integer>();//nouvelle liste qui va contenir toutes les rangées où la personne à deviné
System.out.println(".______ ___ .___________.___________. __ _______ _______. __ __ __ .______ \r\n" +
"| _ \\ / \\ | | || | | ____| / || | | | | | | _ \\ \r\n" +
"| |_) | / ^ \\ `---| |----`---| |----`| | | |__ | (----`| |__| | | | | |_) | \r\n" +
"| _ < / /_\\ \\ | | | | | | | __| \\ \\ | __ | | | | ___/ \r\n" +
"| |_) | / _____ \\ | | | | | `----.| |____.----) | | | | | | | | | \r\n" +
"|______/ /__/ \\__\\ |__| |__| |_______||_______|_______/ |__| |__| |__| | _| ");//imprime le mot battleship
System.out.println("\n Choisissez un niveau de difficulté: \n 1 (grand bateau) \n 2 (bateau moyen) \n 3 (petit bateau)");//demande à l'utilisateur de choisir le niveau de difficulté du jeu

int difficulty=in.nextInt();//
if(difficulty==1) {
boatStrength=5;
}else if(difficulty==2) {
boatStrength=4;
}else if(difficulty==3) {
boatStrength=3;
}
int[] coordinates=verticalCoordinateGenerator(boatStrength+1);
System.out.println("Colonne: "+coordinates[0]);
for(int i=1; i<coordinates.length; i++) {
System.out.println(coordinates[i]);
}
int j=1;
int hitCount=0;
int row=0;
int column=0;

do {
System.out.println("Devinette #"+j);
System.out.println("Devinez où le bateau se trouve: ");
locationGrid();
System.out.print("Colonne: ");
column=in.nextInt();
System.out.println();
System.out.print("Rangée: ");
row=in.nextInt();

hitGrid(row,column);



if(hitOrMiss(column,row, coordinates, allColumnHits, allRowHits)) {
hitCount++;
hitAnimation(hitCount, boatStrength);
}else {
missAnimation();
System.out.println("Vous avez raté!");

}







j++;
}while(j<10 && hitCount!=boatStrength);
if(hitCount==boatStrength) {
victoryAnimation();
System.exit(0);
}else {
gameOverAnimation(coordinates, boatStrength);
System.exit(0);
}




}public static int[] horizontalCoordinateGenerator(int sizeOfBoat) {
int[] coordinates= new int[sizeOfBoat];
do {
coordinates[0]=generateRandomInteger(1,5);
coordinates[1]=generateRandomInteger(1,sizeOfBoat);

for(int i=2; i<sizeOfBoat; i++) {
coordinates[i]=coordinates[i-1]+1;
}
}while(coordinates[coordinates.length-1]>5 || coordinates[0]>5);

return coordinates;
}public static int[] verticalCoordinateGenerator(int sizeOfBoat) {
int[] coordinates=new int[sizeOfBoat];
do {
coordinates[0]=generateRandomInteger(1,sizeOfBoat);
coordinates[1]=generateRandomInteger(1,5);
for(int i=2; i<sizeOfBoat; i++) {
coordinates[i]=coordinates[i-1]+1;
}
}while(coordinates[coordinates.length-1]>5 || coordinates[0]>5);

return coordinates;
}
public static boolean hitOrMiss(int column, int row, int[] coordinates, ArrayList<Integer> allColumnHits, ArrayList<Integer> allRowHits) {

boolean hit=false;

if(allRowHits.contains(row) && allColumnHits.contains(column)){
for(int i=1; i<coordinates.length; i++) {
if(allRowHits.get(i)==row && allColumnHits.get(i)==column) {
hit=false;
System.out.println("Vous avez déjà frappé ce carré");
return hit;
}else {

}
}
}
else {
if(column==coordinates[0]) {
for(int i=1; i<coordinates.length; i++) {
if(row==coordinates[i]) {
hit=true;
break;
}else {

}
}
}else {
hit=false;

}
if(allRowHits.contains(row) && allColumnHits.contains(column)){
for(int i=1; i<coordinates.length; i++) {
if(allRowHits.get(i)==row && allColumnHits.get(i)==column) {
hit=false;
System.out.println("Vous avez déjà frappé ce carré");
return hit;
}else {

}
}
}
else {
if(row==coordinates[0]) {
for(int i=1; i<coordinates.length; i++) {
if(column==coordinates[i]) {
hit=true;
break;
}else {

}
}
}else {
hit=false;

}
allColumnHits.add(column);
allRowHits.add(row);

}

}


return hit;


}public static int[] coordinateGenerator(int sizeOfBoat) {
int[] coordinates= new int[sizeOfBoat];
do {
coordinates[0]=generateRandomInteger(1,5);
coordinates[1]=generateRandomInteger(1,sizeOfBoat);

for(int i=2; i<sizeOfBoat; i++) {
coordinates[i]=coordinates[i-1]+1;
}
}while(coordinates[coordinates.length-1]>5);

return coordinates;
}
public static void missAnimation() {
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println("_________________________________________________");


try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println("_________________________________________________");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" /");
System.out.println(" /_");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println("_________________________________________________");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" __");
System.out.println(" / ");
System.out.println(" /___");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println("_________________________________________________");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____");
System.out.println(" / ");
System.out.println(" /____/");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println("_________________________________________________");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|_");
System.out.println(" / / ");
System.out.println(" /____/ ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println("_________________________________________________");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|__ ");
System.out.println(" / / ");
System.out.println(" /____/ ");
System.out.println(" ");
System.out.println(" ");
System.out.println("_________________________________________________");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}

System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|__ ");
System.out.println(" / / ");
System.out.println(" /____/ ");
System.out.println(" ");
System.out.println("_________________________________________________");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|__ ");
System.out.println(" / / ");
System.out.println(" /____/ ");
System.out.println("_________________________________________________");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" _____");
System.out.println(" ______ / \\ ");
System.out.println(" / \\ / /");
System.out.println(" \\ \\ / / ");
System.out.println(" \\ \\ ____|_ / / ");
System.out.println(" \\ \\ / / / /");
System.out.println("_____________\\ \\ /____/__/ /______");




try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}

System.out.println(" ________ __________ ");
System.out.println(" / \\ / / ");
System.out.println(" \\ \\ / / ");
System.out.println(" \\ \\ ____|_ / /");
System.out.println("_______________\\ \\_/ /__/ /______");



try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" _____________ __________ ");
System.out.println(" \\ \\ / / ");
System.out.println(" \\ \\ ____|_ / /");
System.out.println("_______________\\ \\_/ /__/ /______");


try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" _________ ____ ");
System.out.println(" / \\__ __/ \\_ ");
System.out.println(" \\ \\ ____|_ / /");
System.out.println(" ____\\ \\_____/ /__/ /______");



try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" _________ ____ ");
System.out.println(" /_____ \\_____ ____|_ __/ \\ ");
System.out.println("_________\\ \\_____/ /__/ /______");



try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _________ ____|_ ____ ");
System.out.println(" / \\__ / / __/ \\_____");



try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _________ ____ ");
System.out.println(" / \\__________ _____|_ ____/ \\_____");



try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println("_________________________________________________");


try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}

}
public static void hitAnimation(int hitCount, int boatStrength) {
if(hitCount==1) {
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _____________________________ ");
System.out.println(" \\ / ");
System.out.println(" \\ / ");
System.out.println(" \\_______________________/ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _____________________________ ");
System.out.println(" \\ / ");
System.out.println(" \\ / ");
System.out.println(" \\_______________________/ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" /");
System.out.println(" /_");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _____________________________ ");
System.out.println(" \\ / ");
System.out.println(" \\ / ");
System.out.println(" \\_______________________/ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" __");
System.out.println(" / ");
System.out.println(" /___");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _____________________________ ");
System.out.println(" \\ / ");
System.out.println(" \\ / ");
System.out.println(" \\_______________________/ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____");
System.out.println(" / ");
System.out.println(" /____/");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _____________________________ ");
System.out.println(" \\ / ");
System.out.println(" \\ / ");
System.out.println(" \\_______________________/ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|_");
System.out.println(" / / ");
System.out.println(" /____/ ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _____________________________ ");
System.out.println(" \\ / ");
System.out.println(" \\ / ");
System.out.println(" \\_______________________/ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|__ ");
System.out.println(" / / ");
System.out.println(" /____/ ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _____________________________ ");
System.out.println(" \\ / ");
System.out.println(" \\ / ");
System.out.println(" \\_______________________/ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}

System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|__ ");
System.out.println(" / / ");
System.out.println(" /____/ ");
System.out.println(" ");
System.out.println(" _____________________________ ");
System.out.println(" \\ / ");
System.out.println(" \\ / ");
System.out.println(" \\_______________________/ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|__ ");
System.out.println(" / / ");
System.out.println(" /____/ ");
System.out.println(" _____________________________ ");
System.out.println(" \\ / ");
System.out.println(" \\ / ");
System.out.println(" \\_______________________/ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}

System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|_ ");
System.out.println(" / / ");
System.out.println(" ____________________/____/___ ");
System.out.println(" \\ / ");
System.out.println(" \\ / ");
System.out.println(" \\_______________________/ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}

int i=0;
do {
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" * * / ");
System.out.println(" / / ");
System.out.println(" ________________________/_*___ ");
System.out.println(" \\ \\ / ");
System.out.println(" \\ / / ");
System.out.println(" \\_______________________/ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}


System.out.println(" ");
System.out.println(" ");
System.out.println(" | * * ");
System.out.println(" * | * ");
System.out.println(" | * ");
System.out.println(" ___________________*___ __|____ ");
System.out.println(" \\ \\ / ");
System.out.println(" \\ / / ");
System.out.println(" \\___________________\\____/ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}

System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" * * / ");
System.out.println(" / / ");
System.out.println(" ________________________/ _*___ ");
System.out.println(" \\ \\ \\ / ");
System.out.println(" \\ / / / ");
System.out.println(" \\___________________\\ \\___/ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}


System.out.println(" ");
System.out.println(" ");
System.out.println(" | * * ");
System.out.println(" * | * ");
System.out.println(" | * ");
System.out.println(" ___________________*____ |________ ");
System.out.println(" \\ \\ \\ / / ");
System.out.println(" \\ / / /");
System.out.println(" \\___________________\\ \\____/ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
i++;
}while(i<3);



System.out.println(" * * *");
System.out.println(" | * | ");
System.out.println(" * | * ");
System.out.println(" | ");
System.out.println(" ");
System.out.println(" _____________________________ ");
System.out.println(" \\ \\ __/\\ ");
System.out.println(" \\ / __/ / ");
System.out.println(" \\____________________\\ / / ");

try{
Thread.sleep(200);
}catch(Exception e) {
System.out.println();
}
System.out.println(" * * ");
System.out.println(" | | * ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _____________________________ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / __/\\ ");
System.out.println(" \\______________________\\ / / ");

try{
Thread.sleep(200);
}catch(Exception e) {
System.out.println();
}
System.out.println(" | / ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _____________________________ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\______________________\\ __/\\");

try{
Thread.sleep(200);
}catch(Exception e) {
System.out.println();
}
for(int q=0; q<5; q++) {
System.out.println();
}
System.out.println();
System.out.println("VOUS AVEZ FRAPPÉ UN BATEAU!!!");

}
if(hitCount>boatStrength) {
victoryAnimation();
}
else if(hitCount==2) {
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ___________________________ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\______________________\\ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _____________________________ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\______________________\\ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" __");
System.out.println(" / ");
System.out.println(" /___");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _____________________________ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\______________________\\ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____");
System.out.println(" / ");
System.out.println(" /____/");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _____________________________ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\______________________\\ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}

System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|");
System.out.println(" / /");
System.out.println(" /____/ ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _____________________________ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\______________________\\ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|_");
System.out.println(" / / ");
System.out.println(" /____/ ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _____________________________ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\______________________\\ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|__ ");
System.out.println(" / / ");
System.out.println(" /____/ ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _____________________________ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\______________________\\ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}

System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|__ ");
System.out.println(" / / ");
System.out.println(" /____/ ");
System.out.println(" ");
System.out.println(" _____________________________ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\______________________\\ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|__ ");
System.out.println(" / / ");
System.out.println(" /____/ ");
System.out.println(" _____________________________ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\______________________\\ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}

System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|_ ");
System.out.println(" / / ");
System.out.println(" ____________________/____/___ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\______________________\\ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}

int k=0;
int i = 0;
do {
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" * * / ");
System.out.println(" / / ");
System.out.println(" ________________________/_*___ ");
System.out.println(" \\ / \\ ");
System.out.println(" \\ \\ / ");
System.out.println(" \\_______________/_______\\ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}


System.out.println(" ");
System.out.println(" ");
System.out.println(" | * * ");
System.out.println(" * | * ");
System.out.println(" | * ");
System.out.println(" __________________*___ _____| ");
System.out.println(" \\ / / \\ ");
System.out.println(" \\ \\ \\ / ");
System.out.println(" \\_________________/ /______\\ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}

System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" * * / ");
System.out.println(" / / ");
System.out.println(" __________________*___ ");
System.out.println(" \\ / _____ ");
System.out.println(" \\ \\ / \\ ");
System.out.println(" \\_________________/ \\_____\\ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}


System.out.println(" ");
System.out.println(" ");
System.out.println(" | * * ");
System.out.println(" * | * ");
System.out.println(" | * ");
System.out.println(" _______________*______| ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ _____ ");
System.out.println(" \\_________________/ / \\ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
i++;
}while(i<3);



System.out.println(" * * *");
System.out.println(" | * | ");
System.out.println(" * | * ");
System.out.println(" | ");
System.out.println(" ");
System.out.println(" _______________________ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\__________________/ ");

try{
Thread.sleep(200);
}catch(Exception e) {
System.out.println();
}
System.out.println(" * * ");
System.out.println(" | | * ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _______________________ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\__________________/ ");

try{
Thread.sleep(200);
}catch(Exception e) {
System.out.println();
}
System.out.println(" | / ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _______________________ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\__________________/ ");


try{
Thread.sleep(200);
}catch(Exception e) {
System.out.println();
}
for(int q=0; q<5; q++) {
System.out.println();
}
System.out.println();
System.out.println("VOUS AVEZ FRAPPÉ UN BATEAU!!!");
}
else if(hitCount==2) {
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _______________________ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\___________________\\ ");


try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _______________________ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\___________________\\ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" __");
System.out.println(" / ");
System.out.println(" /___");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _______________________ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\___________________\\ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____");
System.out.println(" / ");
System.out.println(" /____/");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _______________________ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\___________________\\ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}

System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|");
System.out.println(" / /");
System.out.println(" /____/ ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _______________________ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\___________________\\ ");


try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|_");
System.out.println(" / / ");
System.out.println(" /____/ ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _______________________ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\___________________\\ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|__ ");
System.out.println(" / / ");
System.out.println(" /____/ ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _______________________ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\___________________\\ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}

System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|__ ");
System.out.println(" / / ");
System.out.println(" /____/ ");
System.out.println(" ");
System.out.println(" _______________________ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\___________________\\ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|__ ");
System.out.println(" / / ");
System.out.println(" /____/ ");
System.out.println(" _______________________ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\___________________\\ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}

System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|_ ");
System.out.println(" / / ");
System.out.println(" __________________/____/___ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\___________________\\ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}

int k=0;
int i = 0;
do {
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" * * / ");
System.out.println(" / / ");
System.out.println(" __________________/____/__ ");
System.out.println(" \\ / \\ ");
System.out.println(" \\ \\ / ");
System.out.println(" \\_______________/______\\ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}


System.out.println(" ");
System.out.println(" ");
System.out.println(" | * * ");
System.out.println(" * | * ");
System.out.println(" | * ");
System.out.println(" __________________/_ _____| ");
System.out.println(" \\ / / \\ ");
System.out.println(" \\ \\ \\ / ");
System.out.println(" \\______________ _/ /______\\ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}

System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" * * / ");
System.out.println(" / / ");
System.out.println(" __________________*__ ");
System.out.println(" \\ / _____ ");
System.out.println(" \\ \\ / \\ ");
System.out.println(" \\________________/ \\_____\\ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}


System.out.println(" ");
System.out.println(" ");
System.out.println(" | * * ");
System.out.println(" * | * ");
System.out.println(" | * ");
System.out.println(" _______________*______| ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ _____ ");
System.out.println(" \\_____________ __/ / \\ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
i++;
}while(i<3);



System.out.println(" * * *");
System.out.println(" | * | ");
System.out.println(" * | * ");
System.out.println(" | ");
System.out.println(" ");
System.out.println(" _______________________ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\__________________/ ");

try{
Thread.sleep(200);
}catch(Exception e) {
System.out.println();
}
System.out.println(" * * ");
System.out.println(" | | * ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _______________________ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\__________________/ ");

try{
Thread.sleep(200);
}catch(Exception e) {
System.out.println();
}
System.out.println(" | / ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _______________________ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\__________________/ ");

try{
Thread.sleep(200);
}catch(Exception e) {
System.out.println();
}
for(int q=0; q<5; q++) {
System.out.println();
}
System.out.println();
System.out.println("VOUS AVEZ FRAPPÉ UN BATEAU!!!");
if(hitCount>boatStrength) {
victoryAnimation();
}

}else if(hitCount==3) {
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _______________________ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\___________________\\ ");


try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _______________________ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\___________________\\ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" __");
System.out.println(" / ");
System.out.println(" /___");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _______________________ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\___________________\\ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____");
System.out.println(" / ");
System.out.println(" /____/");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _______________________ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\___________________\\ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}

System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|");
System.out.println(" / /");
System.out.println(" /____/ ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _______________________ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\___________________\\ ");


try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|_");
System.out.println(" / / ");
System.out.println(" /____/ ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _______________________ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\___________________\\ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|__ ");
System.out.println(" / / ");
System.out.println(" /____/ ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" _______________________ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\___________________\\ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}

System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|__ ");
System.out.println(" / / ");
System.out.println(" /____/ ");
System.out.println(" ");
System.out.println(" _______________________ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\___________________\\ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|__ ");
System.out.println(" / / ");
System.out.println(" /____/ ");
System.out.println(" _______________________ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\___________________\\ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}

System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|_ ");
System.out.println(" / / ");
System.out.println(" __________________/____/___ ");
System.out.println(" \\ \\ ");
System.out.println(" \\ / ");
System.out.println(" \\___________________\\ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}

int k=0;
int i = 0;
do {
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" * * / ");
System.out.println(" / / ");
System.out.println(" __________________/____/__ ");
System.out.println(" \\ / \\ ");
System.out.println(" \\ \\ / ");
System.out.println(" \\_______________/______\\ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}


System.out.println(" ");
System.out.println(" ");
System.out.println(" | * * ");
System.out.println(" * | * ");
System.out.println(" | * ");
System.out.println(" __________________/_ _____| ");
System.out.println(" \\ / / \\ ");
System.out.println(" \\ \\ \\ / ");
System.out.println(" \\______________ _/ /______\\ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}

System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" * * / ");
System.out.println(" / / ");
System.out.println(" __________________*__ ");
System.out.println(" \\ / _____ ");
System.out.println(" \\ \\ / \\ ");
System.out.println(" \\________________/ \\_____\\ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}


System.out.println(" ");
System.out.println(" ");
System.out.println(" | * * ");
System.out.println(" * | * ");
System.out.println(" | * ");
System.out.println(" _____________________| ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ _____ ");
System.out.println(" \\_____________ __/ / \\ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
i++;
}while(i<3);



System.out.println(" * * *");
System.out.println(" | * | ");
System.out.println(" * | * ");
System.out.println(" | ");
System.out.println(" ");
System.out.println(" ____________________ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\_______________/ ");

try{
Thread.sleep(200);
}catch(Exception e) {
System.out.println();
}
System.out.println(" * * ");
System.out.println(" | | * ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____________________ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\_______________/ ");

try{
Thread.sleep(200);
}catch(Exception e) {
System.out.println();
}
System.out.println(" | / ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____________________ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\_______________/ ");

try{
Thread.sleep(200);
}catch(Exception e) {
System.out.println();
}
for(int q=0; q<5; q++) {
System.out.println();
}
System.out.println();
System.out.println("VOUS AVEZ FRAPPÉ UN BATEAU!!!");
if(hitCount>boatStrength) {
victoryAnimation();
}
}
else if(hitCount==4) {
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____________________ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\_______________/ ");


try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____________________ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\_______________/ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" __");
System.out.println(" / ");
System.out.println(" /___");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____________________ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\_______________/ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|__");
System.out.println(" / / ");
System.out.println(" /____/ ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____________________ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\_______________/ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}

System.out.println(" ");
System.out.println(" ");
System.out.println(" ");

System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|__ ");
System.out.println(" / / ");
System.out.println(" /____/ ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____________________ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\_______________/ ");


try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|__ ");
System.out.println(" / / ");
System.out.println(" /____/ ");
System.out.println(" ");
System.out.println(" ____________________ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\_______________/ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|__ ");
System.out.println(" / / ");
System.out.println(" /____/ ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____________________ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\_______________/ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}

System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|__ ");
System.out.println(" / / ");
System.out.println(" /____/ ");
System.out.println(" ");
System.out.println(" ____________________ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\_______________/ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|__ ");
System.out.println(" / / ");
System.out.println(" /____/ ");
System.out.println(" ____________________ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\_______________/ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}

System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ____|__ ");
System.out.println(" / / ");
System.out.println(" ______________/____/ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\_______________/ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}

int k=0;
int i = 0;
do {
System.out.println(" ");
System.out.println(" ");
System.out.println(" | * * ");
System.out.println(" * | * ");
System.out.println(" | * ");
System.out.println(" ______________ _____ ");
System.out.println(" \\ / / ");
System.out.println(" \\ \\ \\ ");
System.out.println(" \\_______________/ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}


System.out.println(" ");
System.out.println(" ");
System.out.println(" | * * ");
System.out.println(" * | * ");
System.out.println(" | * ");
System.out.println(" ______________ _____ ");
System.out.println(" \\ / / / ");
System.out.println(" \\ \\ \\ \\ ");
System.out.println(" \\_________/ /_____/ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}

System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" * * / ");
System.out.println(" / / ");
System.out.println(" ______________ ");
System.out.println(" \\ / _____ ");
System.out.println(" \\ \\ / / ");
System.out.println(" \\_________/ \\ \\ ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}


System.out.println(" ");
System.out.println(" ");
System.out.println(" | * * ");
System.out.println(" * | * ");
System.out.println(" | * ");
System.out.println(" ______________ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ _____ ");
System.out.println(" \\_________/ / / ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
i++;
}while(i<3);



System.out.println(" * * *");
System.out.println(" | * | ");
System.out.println(" * | * ");
System.out.println(" | ");
System.out.println(" ");
System.out.println(" ______________ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\_________/ ");

try{
Thread.sleep(200);
}catch(Exception e) {
System.out.println();
}
System.out.println(" * * ");
System.out.println(" | | * ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ______________ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\_________/ ");

try{
Thread.sleep(200);
}catch(Exception e) {
System.out.println();
}
System.out.println(" | / ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ______________ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\_________/ ");

try{
Thread.sleep(200);
}catch(Exception e) {
System.out.println();
}
for(int q=0; q<5; q++) {
System.out.println();
}
System.out.println();
System.out.println("VOUS AVEZ FRAPPÉ UN BATEAU!!!");
if(hitCount>boatStrength) {
victoryAnimation();
}
}

}public static void victoryAnimation() {
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println("Quelques minutes plus tard......... ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
try {
Thread.sleep(1500);
} catch (Exception e) {
System.out.println();
}

System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ______________ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\_________/ ");
try{
Thread.sleep(200);
}catch(Exception e) {
System.out.println();
}
System.out.println(" OOO ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ______________ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\_________/ ");
try{
Thread.sleep(200);
}catch(Exception e) {
System.out.println();
}
System.out.println(" OOOOO ");
System.out.println(" OOO ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ______________ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\_________/ ");
try{
Thread.sleep(200);
}catch(Exception e) {
System.out.println();
}
System.out.println(" OOO ");
System.out.println(" OOOOO ");
System.out.println(" OOO ");
System.out.println(" ");
System.out.println(" ");
System.out.println(" ______________ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\_________/ ");
try{
Thread.sleep(200);
}catch(Exception e) {
System.out.println();
}
System.out.println(" | ");
System.out.println(" OOO ");
System.out.println(" OOOOO ");
System.out.println(" OOO ");
System.out.println(" ");
System.out.println(" ______________ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\_________/ ");
try{
Thread.sleep(200);
}catch(Exception e) {
System.out.println();
}
System.out.println(" / ");
System.out.println(" | ");
System.out.println(" OOO ");
System.out.println(" OOOOO ");
System.out.println(" OOO ");
System.out.println(" ______________ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\_________/ ");
try{
Thread.sleep(200);
}catch(Exception e) {
System.out.println();
}
System.out.println(" x ");
System.out.println(" / ");
System.out.println(" | ");
System.out.println(" OOO ");
System.out.println(" OOOOO ");
System.out.println(" _____OOO______ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\_________/ ");
try{
Thread.sleep(200);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" x ");
System.out.println(" | ");
System.out.println(" OOO ");
System.out.println(" OOOOO ");
System.out.println(" _____OOO______ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\_________/ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" x ");
System.out.println(" OOO ");
System.out.println(" OOOOO ");
System.out.println(" _____OOO______ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\_________/ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" x ");
System.out.println(" OOO ");
System.out.println(" OOOOO ");
System.out.println(" _____OOO______ ");
System.out.println(" \\ / ");
System.out.println(" \\ \\ ");
System.out.println(" \\_________/ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ");
System.out.println(" \\ x / ");
System.out.println(" \\ O O OO / ");
System.out.println(" O OO O - ");
System.out.println(" /__O___O OO_ __\\__ ");
System.out.println(" \\ _\\ / / ");
System.out.println(" \\_/ / / \\ \\ ");
System.out.println(" \\___\\/______/ ");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ");
System.out.println(" ____ v v ");
System.out.println(" \\ / v ________ ");
System.out.println(" \\/ v \\ / ");
System.out.println(" v v v \\___/ ");
System.out.println(" __ v v ");
System.out.println(" \\_\\ v v ");
System.out.println(" ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" v v v ");
System.out.println(" v v ");
System.out.println(" ");
System.out.println(" v v v v ");
System.out.println(" ");
System.out.println(" v v ");
System.out.println(" v v v v ");
System.out.println(" ");
System.out.println(" v v v v ");

try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" v v v v ");
System.out.println(" v ");
System.out.println(" v ");
System.out.println(" v v ");
System.out.println(" v ");
System.out.println(" v v ");
System.out.println(" v ");
System.out.println(" ");
System.out.println(" v v ");
System.out.println(" v v v v ");
System.out.println(" \r\n" +
" \r\n" +
"\r\n" +
"\r\n" +
"\r\n" +
"");
try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}

System.out.println("\r\n" +
"\r\n" +
"\r\n" +
"\r\n" +
"\r\n" +
"");



 try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ._._._.\r\n" +
" | |\r\n" +
"| |\r\n" +
"\\|\\|\r\n" +
"____\r\n" +
"/\\/");



 try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ._._._.\r\n" +
"_| | | |\r\n" +
"\\ | | |\r\n" +
"_/\\|\\|\\|\r\n" +
" >_____\r\n" +
"/\\/\\/\\/");



 try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ._._._.\r\n" +
" ____| | | |\r\n" +
" __ \\ | | |\r\n" +
" ___/\\|\\|\\|\r\n" +
"\\___ >_____\r\n" +
" \\/\\/\\/\\/");



 try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ._._._.\r\n" +
"__ ____| | | |\r\n" +
" \\_/ __ \\ | | |\r\n" +
"| \\ ___/\\|\\|\\|\r\n" +
"| /\\___ >_____\r\n" +
"\\/ \\/\\/\\/\\/");



 try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ._._._.\r\n" +
" ____ ____| | | |\r\n" +
"/ \\_/ __ \\ | | |\r\n" +
"> | \\ ___/\\|\\|\\|\r\n" +
"|___| /\\___ >_____\r\n" +
" \\/ \\/\\/\\/\\/");



 try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ._._._.\r\n" +
"___ ____ ____| | | |\r\n" +
"__\\ / \\_/ __ \\ | | |\r\n" +
"_/ > | \\ ___/\\|\\|\\|\r\n" +
"_ /|___| /\\___ >_____\r\n" +
"_/ \\/ \\/\\/\\/\\/");



 try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ._._._.\r\n" +
" ____ ____ ____| | | |\r\n" +
" / ___\\ / \\_/ __ \\ | | |\r\n" +
"_/ /_/ > | \\ ___/\\|\\|\\|\r\n" +
"/\\___ /|___| /\\___ >_____\r\n" +
"_____/ \\/ \\/\\/\\/\\/");



 try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ._._._.\r\n" +
"__ ____ ____ ____| | | |\r\n" +
" \\ / ___\\ / \\_/ __ \\ | | |\r\n" +
"__ \\_/ /_/ > | \\ ___/\\|\\|\\|\r\n" +
"__ /\\___ /|___| /\\___ >_____\r\n" +
" \\//_____/ \\/ \\/\\/\\/\\/");



 try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ._._._.\r\n" +
"______ ____ ____ ____| | | |\r\n" +
"\\__ \\ / ___\\ / \\_/ __ \\ | | |\r\n" +
" > __ \\_/ /_/ > | \\ ___/\\|\\|\\|\r\n" +
" (____ /\\___ /|___| /\\___ >_____\r\n" +
"/ \\//_____/ \\/ \\/\\/\\/\\/");



 try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ._._._.\r\n" +
" _________ ____ ____ ____| | | |\r\n" +
" ___\\__ \\ / ___\\ / \\_/ __ \\ | | |\r\n" +
" /_/ > __ \\_/ /_/ > | \\ ___/\\|\\|\\|\r\n" +
"___ (____ /\\___ /|___| /\\___ >_____\r\n" +
"____/ \\//_____/ \\/ \\/\\/\\/\\/");



 try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ._._._.\r\n" +
"_ _________ ____ ____ ____| | | |\r\n" +
" / ___\\__ \\ / ___\\ / \\_/ __ \\ | | |\r\n" +
" / /_/ > __ \\_/ /_/ > | \\ ___/\\|\\|\\|\r\n" +
"\\ \\___ (____ /\\___ /|___| /\\___ >_____\r\n" +
"/ /_____/ \\//_____/ \\/ \\/\\/\\/\\/");



 try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ._._._.\r\n" +
"_____ _________ ____ ____ ____| | | |\r\n" +
" / / ___\\__ \\ / ___\\ / \\_/ __ \\ | | |\r\n" +
" / / /_/ > __ \\_/ /_/ > | \\ ___/\\|\\|\\|\r\n" +
"___ \\ \\___ (____ /\\___ /|___| /\\___ >_____\r\n" +
" \\/ /_____/ \\//_____/ \\/ \\/\\/\\/\\/");



 try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ._._._.\r\n" +
" ________ _________ ____ ____ ____| | | |\r\n" +
"\\___ / / ___\\__ \\ / ___\\ / \\_/ __ \\ | | |\r\n" +
"/ / / / /_/ > __ \\_/ /_/ > | \\ ___/\\|\\|\\|\r\n" +
" >_____ \\ \\___ (____ /\\___ /|___| /\\___ >_____\r\n" +
"/ \\/ /_____/ \\//_____/ \\/ \\/\\/\\/\\/");



 try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ._._._.\r\n" +
"____ ________ _________ ____ ____ ____| | | |\r\n" +
"__ \\\\___ / / ___\\__ \\ / ___\\ / \\_/ __ \\ | | |\r\n" +
" ___/ / / / /_/ > __ \\_/ /_/ > | \\ ___/\\|\\|\\|\r\n" +
"___ >_____ \\ \\___ (____ /\\___ /|___| /\\___ >_____\r\n" +
" \\/ \\/ /_____/ \\//_____/ \\/ \\/\\/\\/\\/");



 try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ._._._.\r\n" +
" __ ____ ________ _________ ____ ____ ____| | | |\r\n" +
"/ // __ \\\\___ / / ___\\__ \\ / ___\\ / \\_/ __ \\ | | |\r\n" +
" /\\ ___/ / / / /_/ > __ \\_/ /_/ > | \\ ___/\\|\\|\\|\r\n" +
"/ \\___ >_____ \\ \\___ (____ /\\___ /|___| /\\___ >_____\r\n" +
" \\/ \\/ /_____/ \\//_____/ \\/ \\/\\/\\/\\/");



 try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ._._._.\r\n" +
"___ __ ____ ________ _________ ____ ____ ____| | | |\r\n" +
"\\ \\/ // __ \\\\___ / / ___\\__ \\ / ___\\ / \\_/ __ \\ | | |\r\n" +
"\\\\ /\\ ___/ / / / /_/ > __ \\_/ /_/ > | \\ ___/\\|\\|\\|\r\n" +
" /\\_/ \\___ >_____ \\ \\___ (____ /\\___ /|___| /\\___ >_____\r\n" +
"/ \\/ \\/ /_____/ \\//_____/ \\/ \\/\\/\\/\\/");



 try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ._._._.\r\n" +
"___ ___ __ ____ ________ _________ ____ ____ ____| | | |\r\n" +
"_ \\\\ \\/ // __ \\\\___ / / ___\\__ \\ / ___\\ / \\_/ __ \\ | | |\r\n" +
" __ \\\\ /\\ ___/ / / / /_/ > __ \\_/ /_/ > | \\ ___/\\|\\|\\|\r\n" +
"___ /\\_/ \\___ >_____ \\ \\___ (____ /\\___ /|___| /\\___ >_____\r\n" +
" \\/ \\/ \\/ /_____/ \\//_____/ \\/ \\/\\/\\/\\/");



 try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ._._._.\r\n" +
"_ _____ ___ __ ____ ________ _________ ____ ____ ____| | | |\r\n" +
"/ \\__ \\\\ \\/ // __ \\\\___ / / ___\\__ \\ / ___\\ / \\_/ __ \\ | | |\r\n" +
" / __ \\\\ /\\ ___/ / / / /_/ > __ \\_/ /_/ > | \\ ___/\\|\\|\\|\r\n" +
"> (____ /\\_/ \\___ >_____ \\ \\___ (____ /\\___ /|___| /\\___ >_____\r\n" +
" \\/ \\/ \\/ /_____/ \\//_____/ \\/ \\/\\/\\/\\/");



 try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ._._._.\r\n" +
"_____ _____ ___ __ ____ ________ _________ ____ ____ ____| | | |\r\n" +
" ___/ \\__ \\\\ \\/ // __ \\\\___ / / ___\\__ \\ / ___\\ / \\_/ __ \\ | | |\r\n" +
"__ \\ / __ \\\\ /\\ ___/ / / / /_/ > __ \\_/ /_/ > | \\ ___/\\|\\|\\|\r\n" +
"__ > (____ /\\_/ \\___ >_____ \\ \\___ (____ /\\___ /|___| /\\___ >_____\r\n" +
" \\/ \\/ \\/ \\/ /_____/ \\//_____/ \\/ \\/\\/\\/\\/");



 try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ._._._.\r\n" +
"_ ______ _____ ___ __ ____ ________ _________ ____ ____ ____| | | |\r\n" +
" \\/ ___/ \\__ \\\\ \\/ // __ \\\\___ / / ___\\__ \\ / ___\\ / \\_/ __ \\ | | |\r\n" +
" /\\___ \\ / __ \\\\ /\\ ___/ / / / /_/ > __ \\_/ /_/ > | \\ ___/\\|\\|\\|\r\n" +
"//____ > (____ /\\_/ \\___ >_____ \\ \\___ (____ /\\___ /|___| /\\___ >_____\r\n" +
" \\/ \\/ \\/ \\/ /_____/ \\//_____/ \\/ \\/\\/\\/\\/");



 try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ._._._.\r\n" +
"__ __ ______ _____ ___ __ ____ ________ _________ ____ ____ ____| | | |\r\n" +
" | \\/ ___/ \\__ \\\\ \\/ // __ \\\\___ / / ___\\__ \\ / ___\\ / \\_/ __ \\ | | |\r\n" +
" | /\\___ \\ / __ \\\\ /\\ ___/ / / / /_/ > __ \\_/ /_/ > | \\ ___/\\|\\|\\|\r\n" +
"____//____ > (____ /\\_/ \\___ >_____ \\ \\___ (____ /\\___ /|___| /\\___ >_____\r\n" +
" \\/ \\/ \\/ \\/ /_____/ \\//_____/ \\/ \\/\\/\\/\\/");



 try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println("___ ._._._.\r\n" +
"__ __ __ ______ _____ ___ __ ____ ________ _________ ____ ____ ____| | | |\r\n" +
"_ \\| | \\/ ___/ \\__ \\\\ \\/ // __ \\\\___ / / ___\\__ \\ / ___\\ / \\_/ __ \\ | | |\r\n" +
"_> ) | /\\___ \\ / __ \\\\ /\\ ___/ / / / /_/ > __ \\_/ /_/ > | \\ ___/\\|\\|\\|\r\n" +
"__/|____//____ > (____ /\\_/ \\___ >_____ \\ \\___ (____ /\\___ /|___| /\\___ >_____\r\n" +
" \\/ \\/ \\/ \\/ /_____/ \\//_____/ \\/ \\/\\/\\/\\/");



 try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println("___ ._._._.\r\n" +
" /___ __ __ ______ _____ ___ __ ____ ________ _________ ____ ____ ____| | | |\r\n" +
" / _ \\| | \\/ ___/ \\__ \\\\ \\/ // __ \\\\___ / / ___\\__ \\ / ___\\ / \\_/ __ \\ | | |\r\n" +
"( <_> ) | /\\___ \\ / __ \\\\ /\\ ___/ / / / /_/ > __ \\_/ /_/ > | \\ ___/\\|\\|\\|\r\n" +
" \\____/|____//____ > (____ /\\_/ \\___ >_____ \\ \\___ (____ /\\___ /|___| /\\___ >_____\r\n" +
" \\/ \\/ \\/ \\/ /_____/ \\//_____/ \\/ \\/\\/\\/\\/");



 try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println(" ____ ._._._.\r\n" +
"\\ / /___ __ __ ______ _____ ___ __ ____ ________ _________ ____ ____ ____| | | |\r\n" +
" Y / _ \\| | \\/ ___/ \\__ \\\\ \\/ // __ \\\\___ / / ___\\__ \\ / ___\\ / \\_/ __ \\ | | |\r\n" +
" ( <_> ) | /\\___ \\ / __ \\\\ /\\ ___/ / / / /_/ > __ \\_/ /_/ > | \\ ___/\\|\\|\\|\r\n" +
"___/ \\____/|____//____ > (____ /\\_/ \\___ >_____ \\ \\___ (____ /\\___ /|___| /\\___ >_____\r\n" +
" \\/ \\/ \\/ \\/ /_____/ \\//_____/ \\/ \\/\\/\\/\\/");



 try{
Thread.sleep(100);
}catch(Exception e) {
System.out.println();
}
System.out.println("____ ____ _ ._._._.\r\n" +
"\\ \\ / /___ __ __ ______ _____ ___ __ ____ ________ _________ ____ ____ _//_| | | |\r\n" +
" \\ Y / _ \\| | \\/ ___/ \\__ \\\\ \\/ // __ \\\\___ / / ___\\__ \\ / ___\\ / \\_/ __ \\ | | |\r\n" +
" \\ ( <_> ) | /\\___ \\ / __ \\\\ /\\ ___/ / / / /_/ > __ \\_/ /_/ > | \\ ___/\\|\\|\\|\r\n" +
" \\___/ \\____/|____//____ > (____ /\\_/ \\___ >_____ \\ \\___ (____ /\\___ /|___| /\\___ >_____\r\n" +
" \\/ \\/ \\/ \\/ /_____/ \\//_____/ \\/ \\/\\/\\/\\/");
try{
Thread.sleep(500);
}catch(Exception e) {
System.out.println();
}
}public static void gameOverAnimation(int[] coordinates, int boatLength) {
System.out.println("____ ____ .___ \r\n" +
"\\ \\ / /___ __ __ ______ _____ ___ __ ____ ________ ______ ___________ __| _/_ __ \r\n" +
" \\ Y / _ \\| | \\/ ___/ \\__ \\\\ \\/ // __ \\\\___ / \\____ \\_/ __ \\_ __ \\/ __ | | \\\r\n" +
" \\ ( <_> ) | /\\___ \\ / __ \\\\ /\\ ___/ / / | |_> > ___/| | \\/ /_/ | | /\r\n" +
" \\___/ \\____/|____//____ > (____ /\\_/ \\___ >_____ \\ | __/ \\___ >__| \\____ |____/ \r\n" +
" \\/ \\/ \\/ \\/ |__| \\/ \\/ ");
try{
Thread.sleep(500);
}catch(Exception e) {
System.out.println();
}

System.out.print("Les coordonnées du bateau sont: \n Colonne "+coordinates[0]+"\n Rangées ");
for(int i=0; i<boatLength-2; i++) {
System.out.print(coordinates[i+1]+", ");
}
System.out.println("et "+coordinates[boatLength-1]);
}public static void hitGrid(int row, int column) {
String one="-";
String two="-";
String three="-";
String four="-";
String five="-";
String six="-";
String seven ="-";
String eight="-";
String nine="-";
String ten="-";
String eleven="-";
String twelve="-";
String thirteen="-";
String fourteen="-";
String fifteen="-";
String sixteen="-";
String seventeen="-";
String eighteen="-";
String nineteen="-";
String twenty="-";
String twentyone="-";
String twentytwo="-";
String twentythree="-";
String twentyfour="-";
String twentyfive="-";


if(row==1) {
if(column==1) {
one="X";
}else if(column==2) {
two="X";
}else if(column==3) {
three="X";
}else if(column==4) {
four="X";
}else if(column==5) {
five="X";
}
}
if(row==2) {
if(column==1) {
six="X";
}else if(column==2) {
seven="X";
}else if(column==3) {
eight="X";
}else if(column==4) {
nine="X";
}else if(column==5) {
ten="X";
}
}
if(row==3) {
if(column==1) {
eleven="X";
}else if(column==2) {
twelve="X";
}else if(column==3) {
thirteen="X";
}else if(column==4) {
fourteen="X";
}else if(column==5) {
fifteen="X";
}
}
if(row==4) {
if(column==1) {
sixteen="X";
}else if(column==2) {
seventeen="X";
}else if(column==3) {
eighteen="X";
}else if(column==4) {
nineteen="X";
}else if(column==5) {
twenty="X";
}
}
if(row==5) {
if(column==1) {
twentyone="X";
}else if(column==2) {
twentytwo="X";
}else if(column==3) {
twentythree="X";
}else if(column==4) {
twentyfour="X";
}else if(column==5) {
twentyfive="X";
}
}

System.out.println("+-1-+-2-+-3-+-4-+-5-+\r\n" +
"1 "+one+" | "+two+" | "+three+" | "+four+" | "+five+" |\r\n" +
"+---+---+---+---+---+\r\n" +
"2 "+six+" | "+seven+" | "+eight+" | "+nine+" | "+ten+" |\r\n" +
"+---+---+---+---+---+\r\n" +
"3 "+eleven+" | "+twelve+" | "+thirteen+" | "+fourteen+" | "+fifteen+" |\r\n" +
"+---+---+---+---+---+\r\n" +
"4 "+sixteen+" | "+seventeen+" | "+eighteen+" | "+nineteen +" | "+twenty +" |\r\n" +
"+---+---+---+---+---+\r\n" +
"5 "+twentyone+" | "+twentytwo+" | "+ twentythree+" | "+ twentyfour+" | "+ twentyfive+" |\r\n" +
"+---+---+---+---+---+");
try {
Thread.sleep(2000);
}catch(Exception e) {
System.out.println();
}
}
public static int generateRandomInteger(int min, int max) {
int randomNumber=(int) ((Math.random() * (max - min+1)) + min);
return randomNumber;
}public static void locationGrid() {
String one="-";
String two="-";
String three="-";
String four="-";
String five="-";
String six="-";
String seven ="-";
String eight="-";
String nine="-";
String ten="-";
String eleven="-";
String twelve="-";
String thirteen="-";
String fourteen="-";
String fifteen="-";
String sixteen="-";
String seventeen="-";
String eighteen="-";
String nineteen="-";
String twenty="-";
String twentyone="-";
String twentytwo="-";
String twentythree="-";
String twentyfour="-";
String twentyfive="-";

System.out.println("+-1-+-2-+-3-+-4-+-5-+\r\n" +
"1 "+one+" | "+two+" | "+three+" | "+four+" | "+five+" |\r\n" +
"+---+---+---+---+---+\r\n" +
"2 "+six+" | "+seven+" | "+eight+" | "+nine+" | "+ten+" |\r\n" +
"+---+---+---+---+---+\r\n" +
"3 "+eleven+" | "+twelve+" | "+thirteen+" | "+fourteen+" | "+fifteen+" |\r\n" +
"+---+---+---+---+---+\r\n" +
"4 "+sixteen+" | "+seventeen+" | "+eighteen+" | "+nineteen +" | "+twenty +" |\r\n" +
"+---+---+---+---+---+\r\n" +
"5 "+twentyone+" | "+twentytwo+" | "+ twentythree+" | "+ twentyfour+" | "+ twentyfive+" |\r\n" +
"+---+---+---+---+---+");
try {
Thread.sleep(2000);
}catch(Exception e) {
System.out.println();
}
}
}