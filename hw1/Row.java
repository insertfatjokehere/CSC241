class Row {
    int userInput;
    String display = "";
    void draw() {
        int stars = this.userInput;
       if(stars == 0){
		System.out.println("");

	} else { for (int i = 0; i < stars; i++) {
	
            display = display + "*";

        }
		System.out.println(display);
}

    }
}
