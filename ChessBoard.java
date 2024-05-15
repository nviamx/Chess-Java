
public class ChessBoard {
	private ChessPiece pieces[];

	public ChessBoard() {
		this.pieces = new ChessPiece[10];
	}

	public String toString() {
		String str = "";
		for (int i = 0; i < pieces.length; i++) {
			if (pieces[i] != null) {
				str += pieces[i].toString() + "\n";
			}
		}
		return str.substring(0, str.length() - 1);
	}

	public void addPiece(ChessPiece p) {
		for (int i = 0; i < pieces.length; i++) {
			if (pieces[i] == null) {
				pieces[i] = p;
				break;
			}
		}
	}

	public boolean threats(int p1, int p2) {
		if (p1 < 0 || p1 >= this.pieces.length || p2 < 0 || p2 >= this.pieces.length || this.pieces[p1] == null
				|| this.pieces[p2] == null)
			return false;
		Position new_p[] = this.pieces[p1].moves(this.pieces[p1].getPosition());
		int row = this.pieces[p2].getPosition().getRow();
		int col = this.pieces[p2].getPosition().getCol();
		for (int i = 0; i < new_p.length; i++) {
			if (new_p[i].getRow() == row && new_p[i].getCol() == col)
				return true;
		}
		return false;
	}

	public String whoThreatsWho() {
		String str = "";
		for (int i = 0; i < this.pieces.length; i++) {
			for (int j = 0; j < this.pieces.length; j++) {
				if (i == j)
					continue;
				if (threats(i, j) == true) {
					str += this.pieces[i].toString() + " threats " + this.pieces[j].toString() + "\n";
				}
			}
		}
		return str;
	}
}
