import UIKit
import app

class ViewController: UIViewController, FortuneView {
    @IBOutlet weak var label: UILabel!
    @IBOutlet weak var activityIndicator: UIActivityIndicatorView!
    
    var presenter: FortunePresenter!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        presenter = Container().fortunePresenter(fortuneView: self)
        presenter.onCreate()
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    func showLoading(visible: Bool) {
        fatalError("Implement this")
    }
    
    @IBAction func nextFortune(_ sender: Any) {
    }
    
    @IBAction func saveFavorite(_ sender: Any) {
    }
    
    func displayError(e: KotlinException) {
        fatalError("Implement this")
        
    }
    
    func displayFortune(text: String) {
        fatalError("Implement this")
    }
    
    deinit {
        presenter.onDestroy()
    }
}
