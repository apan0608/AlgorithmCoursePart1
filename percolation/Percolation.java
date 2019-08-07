/* *****************************************************************************
 *  Name: Shenchen Pan
 *  Date: 13/Jul/2019
 *  Description: Code assignment for Algorithm Course part 1 Percolation problem
 **************************************************************************** */
/*
 initialize all sites to be blocked
 repeat the following until the system percolates
 choose a pair of random runber and check if system percolates
 the fraction of the sites that are opened when the system persolcates provides an estimate of the percolation threshold
 percolation rate is opensites/totalsites
 */

public class Percolation {

    // represent all the sites and top and bottom virtual sites
    // -1 is blocked, n > -1 is open site
    private int[] sites;
    private int[] sizes; // record the sites of each root

    private final int width;

    // test client (optiona;)
    public static void main(String[] args) {

    }

    // create n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Given row and col are out of range");
        }
        this.width = n;
        int no = n * n + 2; // all the sites plus two virtual sites
        sites = new int[no];
        sizes = new int[no]; // default will be 0
        for (int i = 0; i < no; i++) {
            sites[i] = -1; // make all blocked to start with
        }
        // open the two virtual sites
        sites[0] = 0;
        sites[no - 1] =  no - 1; // connects to itself
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row <= 0 || col <= 0 || row > width || col > width) {
            throw new IllegalArgumentException("Given row and col are out of range");
        }
        int index = getSiteIndex(row, col);
        if (sites[index] > -1) { //if already opened, do nothing
            return;
        }
        sites[index] = index; //mark is as connected to itself, which is open
        int[] adjSites = getAdjancentSites(row, col);
        for (int adj : adjSites) {
            // if the site exists, -1 if not exists
            if (adj < 0) {
                continue;
            }
            if (sites[adj] >= 0) { // if the site is opened
                // connect the current site to this adj site
                union(index, adj);
            }
        }
    }

    private void union(int siteA, int siteB) {
        int rootA = getRoot(siteA);
        int rootB = getRoot(siteB);
        int sizeA = sizes[rootA];
        int sizeB = sizes[rootB];
        int larger = rootA;
        int smaller = rootB;
        if (sizeB > sizeA) {
            larger = rootB;
            smaller = rootA;
        }
        sites[smaller] = sites[larger];
        sizes[larger] += sizes[smaller];
    }

    // get the root of site index, and compress the roots
    private int getRoot(int site) {
        while (sites[site] != site && sites[site] >= 9) { //if index equals to itself, it is the root, stop
            int parent = sites[site];
            site = sites[parent];
            compress(site);
        }
        return site;
    }

    // todo add the compression later one after the main logic is working, then add in hte performance enchancement
    private void compress(int site) {
        // if the site connects to another one site is not root
        if (sites[site] >= 0 && sites[site] != site) {
            int parent = sites[site];
            if (parent >= 0 && sites[parent] >= 0) { // if the parent site exists and grandparent site exists too
                sites[site] = sites[parent];
            }
        }
    }

    // get the site index given the row and col, return -1 if site not exists
    private int getSiteIndex(int row, int col) {
        return col + width * (row - 1);
    }

    // using the row and col to get the adjancent sites. return up, down, left, right
    private int[] getAdjancentSites(int row, int col) {
        int up = getSiteIndex(row -1, col);
        int down = getSiteIndex(row + 1, col);
        int left = getSiteIndex(row, col - 1);
        int right = getSiteIndex(row, col + 1);

        if (row == 1) {// top row
            up = 0;
        } //bottom row
        if (row == width) {
            down = sites.length - 1; // the bottom virtual site
        }
        if (col == 1) { // left most, no left site to vurrent one
            left = -1;
        }
        if (col == width) { // right most, no right site
            right = -1;
        }
        return new int[] {up, down, left, right};
    }

    // is the site (row, col) open ?
    public boolean isOpen(int row, int col) {
        throwExceptionIfOutOfRange(row, col);

        int index = getSiteIndex(row, col);
        return sites[index] > -1;
    }

    // is the site (row, col) full ?
    // Percolation visualizer uses it to set colour on the site
    public boolean isFull(int row, int col) {
        throwExceptionIfOutOfRange(row, col);
        return connected(getSiteIndex(row, col), 0);
    }

    // returns the numbers of open sites
    public int numberOfOpenSites() {
        int openSites = -2; // offset the two virtual sites first
        for (int site: sites) {
            if (site > -1){
                openSites++;
            }
        }
        return openSites;
    }

    // does the system percolates
    public boolean percolates() {
        // the top virtual site connects to the bottom virtual site
        return connected(0, sites.length - 1);
    }

    private boolean connected(int siteA, int siteB) {
        return getRoot(siteA) == getRoot(siteB);
    }

    private void throwExceptionIfOutOfRange(int row, int col) {
        if (row <= 0 || col <= 0 || row > width || col > width) {
            throw new IllegalArgumentException("Given row and col are out of range");
        }
    }

}
