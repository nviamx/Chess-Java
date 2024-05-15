
public class Rook implements ChessPiece {
	private Position p;

	public Rook(Position p) {
		if (p == null) {
			throw new NullPointerException("Position is null");
		} else if ((p.getCol() <= 8 && p.getCol() > 0) && (p.getRow() <= 8 && p.getRow() > 0)) {
			this.p = new Position(p.getRow(), p.getCol());
		} else {
			this.p = null;
			throw new NullPointerException("Position is invalid");
		}
	}

	private int Rigth(int col, int row, int size, Position[] new_p) {
		for (int i = col + 1; i <= 8; i++) {
			new_p[size] = new Position(row, i);
			size++;
		}
		return size;
	}

	private int Lift(int col, int row, int size, Position[] new_p) {
		for (int i = col - 1; i > 0; i--) {
			new_p[size] = new Position(row, i);
			size++;
		}
		return size;
	}

	private int UP(int col, int row, int size, Position[] new_p) {
		for (int i = row - 1; i > 0; i--) {
			new_p[size] = new Position(i, col);
			size++;
		}
		return size;
	}

	private int Down(int col, int row, int size, Position[] new_p) {
		for (int i = row + 1; i <= 8; i++) {
			new_p[size] = new Position(i, col);
			size++;
		}
		return size;
	}

	@Override
	public Position[] moves(Position p) {
		if (p.getRow() != this.p.getRow() || p.getCol() != this.p.getCol())
			return new Position[0];
		int max_col = 8, max_row = 8;
		int min_col = 1, min_row = 1;
		int size_Down = max_row - p.getRow();
		int size_Rigth = max_col - p.getCol();
		int size_UP = p.getRow() - min_row;
		int size_Lift = p.getCol() - min_col;
		int size = size_Down + size_Rigth + size_UP + size_Lift;
		if (size == 0)
			return new Position[0];
		Position new_p[] = new Position[size];
		size = 0;
		size = Rigth(p.getCol(), p.getRow(), size, new_p);
		size = Lift(p.getCol(), p.getRow(), size, new_p);
		size = UP(p.getCol(), p.getRow(), size, new_p);
		size = Down(p.getCol(), p.getRow(), size, new_p);
		return new_p;
	}

	@Override
	public Position getPosition() {
		return new Position(this.p.getRow(), this.p.getCol());
	}

	public String toString() {
		return "Rook at (" + this.p.getRow() + ", " + this.p.getCol() + ")";
	}
}
