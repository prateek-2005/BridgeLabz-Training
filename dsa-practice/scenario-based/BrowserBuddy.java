import java.util.*;
class PageNode{
	String url;
	PageNode prev;
	PageNode next;
	public PageNode(String url) {
		this.url=url;
		this.prev=null;
		this.next=null;
	}
}

class Tab{
	private PageNode head;
	private PageNode current;
	
	public void visit(String url) {
		PageNode newPage=new PageNode(url);
		if(head==null) {
			head=current=newPage;
		}
		else {
			current.next=newPage;
			newPage.prev=current;
			current=newPage;
		}
		System.out.println("Visisted: "+url);
	}
	
	public void back() {
		if(current !=null && current.prev!=null) {
			current=current.prev;
			System.out.println("Moved Back To: "+current.url);
		}
		else {
			System.out.println("No Previous Page.");
		}
	}
	
	public void forward() {
		if(current !=null && current.next!=null) {
			current=current.next;
			System.out.println("Moved Forward To: "+current.url);
		}
		else {
			System.out.println("No Next Page.");
		}
	}
	
	public String getCurrentPage() {
		return current!=null ? current.url:"Empty Tab";
	}
	
	public void showHistory() {
		PageNode temp=head;
		System.out.println("History: ");
		while(temp!=null) {
			if(temp==current) {
				System.out.print("["+temp.url+"]");
			}
			else {
				System.out.println(temp.url+" ");
			}
			temp=temp.next;
		}
		System.out.println();
	}
}

class Browser{
	private Tab currentTab;
	private Stack<Tab> closedTabs;
	
	public Browser() {
		currentTab=new Tab();
		closedTabs=new Stack<>();
	}
	
	public void visitPage(String url) {
		currentTab.visit(url);
	}
	
	public void back() {
		currentTab.back();
	}
	
	public void forward() {
		currentTab.forward();
	}
	
	public void closeTab() {
        closedTabs.push(currentTab);
        currentTab = new Tab();
        System.out.println("Tab closed.");
    }

    public void restoreTab() {
        if (!closedTabs.isEmpty()) {
            currentTab = closedTabs.pop();
            System.out.println("Tab restored. Current page: " + currentTab.getCurrentPage());
        } else {
            System.out.println("No closed tabs to restore.");
        }
    }

    public void showHistory() {
        currentTab.showHistory();
    }
}
public class BrowserBuddy {

	public static void main(String[] args) {
		Browser browser = new Browser();

        browser.visitPage("google.com");
        browser.visitPage("github.com");
        browser.visitPage("stackoverflow.com");

        browser.back();
        browser.back();
        browser.forward();

        browser.showHistory();

        browser.closeTab();

        browser.restoreTab();
        browser.showHistory();
	}

}
