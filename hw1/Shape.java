class Shape {

    Row[] rows;
    int s=0;
    Shape(int numberOfRows){
    
        rows = new Row[numberOfRows];
        
            for(int i = 0; i < numberOfRows; i++){
            
            rows[i] = new Row();
            }
        
    
    }

        
  
    void draw(int input) {
           if (s == rows.length-1){ 
            rows[s].userInput = input;
		for(int i = 0; i<rows.length; i++){
		rows[i].draw();
		}
		} else {

		rows[s].userInput = input;
		s++;

        }


    }
}
