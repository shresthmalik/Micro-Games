#include <bits/stdc++.h>
using namespace std;

class Game33{
public :

    int Pos[3][3] ;
    int i,j,k,x,mark;
    int winner=0, moves=0;
    int ply=1;
    vector<int> Pus; //contains valid inputs from players i.e. no.s 1 to 9
    int t=9;
    bool chance=true;

    Game33(){
        winner=0; moves=0; ply=1; t=9;
        chance=true;
        while(t--) Pus.push_back(t+1);
        for(i=0;i<3;++i){
            for(j=0;j<3;++j){
                Pos[i][j] = 0 ;
            }
        }
        cout<<"Welcome to the game Tic Tac Toe (3x3)\n\n";
        cout<<"Rules are simple. Every 6th grader knows it.\n";
        cout<<"You need to make a streak of consecutive 3 marks to Win the game.\n\n";
        cout<<"Buttons for positions : \n1 for Top left\n2 for Top middle\n3 for Top right\n";
        cout<<"4 for Middle left\n5 for Center\n6 for Middle right\n7 for Bottom left\n8 for Bottom middle\n9 for Bottom right.\n\n";
        cout<<"Illustrated Below \n\n";
        for(i=0,x=1;i<3;++i){
            for(j=0;j<3;++j,x++){
                cout<<" "<<x<<" ";
                if(j!=2) cout<<"|";
            }cout<<endl;
            if(i!=2){
                for(k=0;k<11;++k) cout<<"-";
                cout<<endl;
            }
        }
        cout<<endl;
    }

    void Move(int inp, bool &chance){

        if(chance) mark = 1;
        else       mark = 2;

        i = (inp-1)/3;
        j = (inp-1)%3;

        if(Pos[i][j]){
            cout<<"Invalid Move : Position already marked.\n";
            chance = !(chance);
        }
        else{
            Pos[i][j] = mark ;
            ++moves;
        }
    }

    void Show(){

        cout<<"\nCurrent Boards\n\n";

        for(i=0;i<3;++i){
            for(j=0;j<3;++j){
                cout<<" "<<Pos[i][j]<<" ";
                if(j!=2) cout<<"|";
            }cout<<endl;
            if(i!=2){
                for(k=0;k<11;++k) cout<<"-";
                cout<<endl;
            }
        }
        cout<<endl;
    }

    bool CheckWinner(){

        //check horizontals
        for(i=0;i<3;++i){
            ply = Pos[i][0];
            for(j=1;(ply)&&j<3;++j){
                if(Pos[i][j]!=ply) break;
                if(j==2){
                    winner = ply;
                    return winner;
                }
            }
        }

        //check verticals
        for(j=0;j<3;++j){
            ply = Pos[0][j];
            for(i=1;(ply)&&i<3;++i){
                if(Pos[i][j]!=ply) break;
                if(i==2){
                    winner = ply;
                    return winner;
                }
            }
        }

        //check diagonals
        // diag '\'
        ply = Pos[0][0];
        for(i=1;(ply)&&i<3;++i){
            if(Pos[i][i]!=ply) break;
            if(i==2){
                winner = ply;
                return winner;
            }
        }

        // diag '/'
        ply = Pos[0][3-1];
        for(i=1,j=3-2;(ply)&&i<3;++i,--j){
            if(Pos[i][j]!=ply) break;
            if(i==2){
                winner = ply;
                return winner;
            }
        }

        return winner;
    }
};

int main(){

    Game33 g;
    string bgn;
    bool chance = true;
    int inp,ply=1,k=0;

    cout<<"Are you ready to begin? : \n";
    cout<<"Press Y to begin, N to exit : ";
    cin>>bgn;

    if((bgn=="Y"||bgn=="y")){

        for(;g.winner==0 && g.moves<9; chance=(!chance)){
            if(chance) ply = 1;
            else       ply = 2;
            g.Show();
            cout<<"Player "<<ply<<" , Select your Position : ";
            cin>>inp;
            if(find((g.Pus).begin(),(g.Pus).end(),(inp))!=(g.Pus).end()){//Input is valid ie between 1 to 9
                g.Move(inp,chance);
            }
            else{
                cout<<"Invalid Position. Try Again\n";
                chance = !(chance);
            }
            if(g.CheckWinner()==0) continue;
            else{
                g.Show();
                cout<<"Player "<<ply<<" WON\n";
                break;
            }

        }

        if(g.winner){
            cout<<"Congratulations Player "<<g.winner<<" You're a winner.\n";
        }
        else{
            g.Show();
            cout<<"Looks like we have a tie.\n";
        }
    }
    else{
        cout<<"Looks like you're frightened by new challenges.\nSee you soon human.\n";
    }

}
